import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n,m, nums[], result[];
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) set.add(Integer.parseInt(st.nextToken()));
        n = set.size();
        nums = new int[n];
        result = new int[m];
        Iterator<Integer> iter = set.iterator();
        for(int i=0; i<n; i++) nums[i] = iter.next();

        Arrays.sort(nums);

        comb(0, 0);

        bw.flush();
        bw.close();
    }

    private static void comb(int cnt, int start) throws IOException {
        if(cnt == m) {
            for(int i=0; i<m; i++) bw.write(result[i] + " ");
            bw.write("\n");
            return;
        }
        for(int i=start; i<n; i++) {
            result[cnt] = nums[i];
            comb(cnt+1, i);
        }
    }

}