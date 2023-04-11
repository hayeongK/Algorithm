class Solution {
    static int lastx, lasty, answer=Integer.MAX_VALUE;
	static boolean[][] isSquare, visited;
    static int[] dirx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] diry = {1, -1, 0, 0, 1, -1, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        isSquare = new boolean[104][104];
        visited = new boolean[104][104];
        lastx = itemX*2;
        lasty = itemY*2;
        for(int[] rec: rectangle) {
        	for(int i=rec[0]*2; i<rec[2]*2+1; i++) {
        		for(int j=rec[1]*2; j<rec[3]*2+1; j++) {
        			isSquare[i][j] = true;
        		}
        	}
        }
        
        visited[characterX*2][characterY*2] = true;
        bfs(characterX*2, characterY*2, 0);
        return answer/2;
    }

	private static void bfs(int x, int y, int dis) {
		if(x==lastx && y==lasty) {
			answer = Math.min(answer, dis);
			return;
		}
		if(dis>answer) return;
		
		for(int d=0; d<4; d++) {
			int nx = x+dirx[d];
			int ny = y+diry[d];
			
			if(!visited[nx][ny] && isSquare[nx][ny]) {
				boolean isWay = false;
				for(int nd=0; nd<8; nd++) {
					if(!isSquare[nx+dirx[nd]][ny+diry[nd]]) isWay = true;
				}
				if(isWay) {
					visited[nx][ny] = true;
					bfs(nx, ny, dis+1);
					visited[nx][ny] = false;
				}
			}
		}
	}
}