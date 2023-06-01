import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int row;
		int col;
		boolean hasGram;
		int cnt;
		public Position(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.hasGram = false;
			this.cnt = cnt;
		}
		
		public Position(int row, int col, boolean hasGram, int cnt) {
			this.row = row;
			this.col = col;
			this.hasGram = hasGram;
			this.cnt = cnt;
		}
	}
	static int arr[][], n, m, t, answer=Integer.MAX_VALUE;
	static boolean hasGram = false;
	static int dirr[] = {1, -1, 0, 0};
	static int dirc[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        
        if(answer == Integer.MAX_VALUE) System.out.println("Fail");
        else System.out.println(answer);
    }

	private static void bfs(int r, int c) {
		boolean visited[][] = new boolean[n][m];
		boolean gvisited[][] = new boolean[n][m];
		Queue<Position> queue = new LinkedList<>();
		Position p = new Position(r, c, 0);
		queue.add(p);
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			if(p.cnt > t) break;
			if(p.row == n-1 && p.col==m-1) {
				answer = p.cnt;
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = p.row + dirr[d];
				int nc = p.col + dirc[d];
				if(nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
				if(p.hasGram) {
					if(!gvisited[nr][nc]) {
						queue.add(new Position(nr, nc, true, p.cnt+1));
						gvisited[nr][nc] = true;
					}
				} else {
					if(visited[nr][nc]) continue;
					if(arr[nr][nc] == 0) {
						queue.add(new Position(nr, nc, p.cnt+1));
						visited[nr][nc] = true;
					} else if(arr[nr][nc] == 2) {
						queue.add(new Position(nr, nc, true, p.cnt+1));
						gvisited[nr][nc] = true;
					}
						
				}
			}
		}
		
	}
    
}