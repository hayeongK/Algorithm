import java.io.*;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<String> set = new TreeSet();
        HashMap<String, Integer> map = new HashMap();
        int cnt = 0;
        String name;

        while(true) {
            name = br.readLine();
            if(name == null) break;
            set.add(name);
            map.put(name, map.getOrDefault(name, 0)+1);
            cnt += 1;
        }

        while(!set.isEmpty()) {
            name = set.pollFirst();
            String value = String.format("%.4f", map.get(name)*100.0f/cnt);
            bw.write(name + " " + value + "\n");
        }

        bw.flush();
        bw.close();
    }
}
