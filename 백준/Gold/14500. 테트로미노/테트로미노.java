import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dirr = {1, -1, 0, 0};
	static int[] dirc = {0, 0, 1, -1};
	static int n, m, answer = 0, arr[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		visited[i][j] = true;
        		bfs(i, j, visited, 1, arr[i][j]);
        		visited[i][j] = false;
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		check(i, j, arr[i][j]);
        	}
        }
        
        System.out.println(answer);
    }
	private static void check(int r, int c, int val) {
		for(int d=0; d<4; d++) {
			int sum = val;
			for(int i=0; i<3; i++) {
				int nr = r+dirr[(d+i)%4];
				int nc = c+dirc[(d+i)%4];
				if(nr<0 || nr>n-1 || nc<0 || nc>m-1) break;
				sum += arr[nr][nc];
			}
			answer = Math.max(answer, sum);
		}
	}
	private static void bfs(int r, int c, boolean[][] visited, int cnt, int sum) {
		if(cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dirr[d];
			int nc = c + dirc[d];
			if(nr>-1 && nr < n && nc>-1 && nc<m && !visited[nr][nc]) {
				visited[nr][nc] = true;
				bfs(nr, nc, visited, cnt+1, sum+arr[nr][nc]);
				visited[nr][nc] = false;
			}
			
		}
	}
}