import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] nitems = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++) nitems[i] = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][n+1];

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(i==j) continue;
                matrix[i][j] = Integer.MAX_VALUE/2;
            }
        }

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            matrix[a][b] = len;
            matrix[b][a] = len;
        }

        for(int k=1; k<n; k++) {
            for(int i=1; i<n; i++) {
                for(int j=i; j<n; j++) {
                    int value = matrix[i][k] + matrix[k][j];
                    if(matrix[i][j] > value) {
                        matrix[i][j] = value;
                        matrix[j][i] = value;
                    }
                }
            }
        }

        int result = 0;
        for(int start=1; start<n; start++) {
            int nitem = 0;
            for(int i=1; i<n; i++) {
                if(m < matrix[start][i]) continue;
                nitem += nitems[i];
            }
            result = Math.max(result, nitem);
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }

}
