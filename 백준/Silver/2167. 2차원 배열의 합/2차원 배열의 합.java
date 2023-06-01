import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n, m, p, q, x, y;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n+1][m+1];
        for(int i=1; i<n+1; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<m+1; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<n+1; i++) {
        	for(int j=1; j<m+1; j++) arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
        }
        
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	p = Integer.parseInt(st.nextToken());
        	q = Integer.parseInt(st.nextToken());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	bw.write(arr[x][y] - arr[x][q-1] - arr[p-1][y] + arr[p-1][q-1] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}