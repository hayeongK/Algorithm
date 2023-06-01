import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) input[i] = Integer.parseInt(st.nextToken());
        
        int[] sum = new int[n];
        sum[0] = input[0];
        
        int answer = input[0];
        for(int i=1; i<n; i++) {
        	for(int j=i-1; j>-1; j--) {
        		if(input[i] > input[j]) {
        			sum[i] = Math.max(sum[i], sum[j]);
        		}
        	}
        	sum[i] += input[i];
        	answer = Math.max(answer, sum[i]);
        }
        
        System.out.println(answer);
    }
}