import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static class Puzzle {
		int no;
		int row;
		int col;
		List<String> shapes = new ArrayList<>();
		public Puzzle(int no, int row, int col) {
			super();
			this.no = no;
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "[no=" + no + ", shape=" + shapes + "]";
		}
	}
	static int[][] dirr = {{0, 0, 1, -1}, {-1, 1, 0, 0}};
	static int[][] dirc = {{1, -1, 0, 0}, {0, 0, -1, 1}};
	static int[][] board, tb;
	static String shape;
	static int nblank = 1, npuzzle=0;
    static HashMap<Integer, List<String>> blanks = new HashMap<>();
	static List<List<Integer>> puzzles = new ArrayList<>();
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
    	board = new int[game_board.length][game_board.length];
    	tb = new int[game_board.length][game_board.length];
    	for(int i=0; i<game_board.length; i++) {
    		for(int j=0; j<game_board.length; j++) {
    			board[i][j] = game_board[i][j];
    			tb[i][j] = table[i][j];
    		}
    	}
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board.length; j++) {
    			if(board[i][j] == 0) { // 보드에서 빈 칸 찾기
    				board[i][j] = ++nblank;
    				shape = "";
    				bfs(i, j);
    				int[][] boardcopy = new int[board.length][board.length];
    				for(int ii=0; ii<board.length; ii++) for(int jj=0; jj<board.length; jj++) boardcopy[ii][jj] = board[ii][jj];
    				boardcopy[i][j] = 1;
    				bfs2(i, j, nblank, boardcopy, 1);
    				board[i][j] = nblank;
    				List<String> temp = new ArrayList<>();
    				temp.add(shape);
    				blanks.put(nblank, temp);
    			}
    		}
    	}
    	
    	
    	for(int i=0; i<3; i++) { // 회전시키기
    		rotate(i);
    	}
    	
    	for(int i=0; i<tb.length; i++) {
    		for(int j=0; j<tb.length; j++) {
    			if(tb[i][j] == 1) { // 퍼즐이 들어갈 수 있는 빈칸 찾기
    				tb[i][j] = 0;
    				int[][] boardcopy = new int[tb.length][tb.length];
    				for(int ii=0; ii<tb.length; ii++) for(int jj=0; jj<tb.length; jj++) boardcopy[ii][jj] = tb[ii][jj];
    				shape = "";
    				bfsTable(i, j, 0);
    				bfsTable2(i, j, boardcopy);
    				List<Integer> plocations = new ArrayList<>();
    				plocations.add(++npuzzle);
    				for(Map.Entry<Integer, List<String>> blank: blanks.entrySet()) {
    					if(blank.getValue().contains(shape)) plocations.add(blank.getKey());
    				}
    				puzzles.add(plocations);
    			}
    		}
    	}
    	
    	List<Integer> remaining = new ArrayList<>();
    	for(int i=2; i<blanks.size()+2; i++) remaining.add(i);
    	
    	for(List<Integer> puzzle: puzzles) { // 칸 수 세기
    		for(int i=1; i<puzzle.size(); i++) {
    			if(remaining.contains(puzzle.get(i))) {
    				answer += blanks.get(puzzle.get(i)).get(0).length()/2;
    				answer++;
    				remaining.remove(puzzle.get(i));
    				break;
    			}
    		}
    	}
        
        return answer;
    }


	private static void rotate(int nth) {
		int[][] rotated = new int[board.length][board.length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(nth == 0) rotated[i][j] = board[board.length-1-j][i]; // 90도
				else if(nth == 1) rotated[i][j] = board[board.length-1-i][board.length-1-j]; //180도
				else rotated[i][j] = board[j][board.length-1-i]; //270도
				
			}
		}
		
		findShape(rotated);
	}

	private static void findShape(int[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j] == 1) continue;
				int cur = map[i][j];
				map[i][j] = 1;
				int[][] boardcopy = new int[map.length][map.length];
				for(int ii=0; ii<map.length; ii++) for(int jj=0; jj<map.length; jj++) boardcopy[ii][jj] = map[ii][jj];
				shape = "";
				bfs2(i, j, cur, map, 0);
				bfs2(i, j, cur, boardcopy, 1);
				blanks.get(cur).add(shape);
			}
		}
	}

	private static void bfs2(int row, int col, int cur, int[][] map, int dd) {
		for(int d=0; d<4; d++) {
			int nr = row + dirr[dd][d];
			int nc = col + dirc[dd][d];
			if(nr>=0 && nr<map.length && nc>=0 && nc<map.length && map[nr][nc]==cur) {
				map[nr][nc] = 1;
				shape += d;
				bfs2(nr, nc, cur, map, dd);
			}
		}
	}
	

	private static void bfs(int row, int col) {
		for(int d=0; d<4; d++) {
			int nr = row + dirr[0][d];
			int nc = col + dirc[0][d];
			if(nr>=0 && nr<board.length && nc>=0 && nc<board.length && board[nr][nc]==0) {
				board[nr][nc] = nblank;
				shape += d;
				bfs(nr, nc);
			}
		}
	}

	private static void bfsTable(int row, int col, int dd) {
		for(int d=0; d<4; d++) {
			int nr = row + dirr[dd][d];
			int nc = col + dirc[dd][d];
			if(nr>=0 && nr<tb.length && nc>=0 && nc<tb.length && tb[nr][nc]==1) {
				tb[nr][nc] = 0;
				shape += d;
				bfsTable(nr, nc, dd);
			}
		}
	}
	
	private static void bfsTable2(int row, int col, int[][] table) {
		for(int d=0; d<4; d++) {
			int nr = row + dirr[1][d];
			int nc = col + dirc[1][d];
			if(nr>=0 && nr<table.length && nc>=0 && nc<table.length && table[nr][nc]==1) {
				table[nr][nc] = 0;
				shape += d;
				bfsTable2(nr, nc, table);
			}
		}
	}
}