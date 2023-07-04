import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) > Math.abs(o2) ? 1 : -1;
            }
        });

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) pq.add(Integer.parseInt(st.nextToken()));

        int first = pq.poll();
        int second;
        int value = Integer.MAX_VALUE;
        int[] result = new int[2];

        for(int i=0; i<n-1; i++) {
            second = pq.poll();
            if(Math.abs(value) > Math.abs(first+second)) {
                value = first+second;
                result[0] = first;
                result[1] = second;
            }
            first = second;
        }

        Arrays.sort(result);
        for(int i=0; i<2; i++) bw.write(result[i] + " ");

        bw.flush();
        bw.close();
    }
}