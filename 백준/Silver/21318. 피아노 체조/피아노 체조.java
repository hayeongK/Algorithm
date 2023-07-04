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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] musics = new int[n];
        int[] records = new int[n];
        st = new StringTokenizer(br.readLine());
        musics[0] = Integer.parseInt(st.nextToken());
        records[0] = 0;
        for(int i=1; i<n; i++) {
            musics[i] = Integer.parseInt(st.nextToken());
            if(musics[i] < musics[i-1]) records[i] = records[i-1]+1;
            else records[i] = records[i-1];
        }

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            bw.write(records[end]-records[start]+"\n");

        }

        bw.flush();
        bw.close();
    }

}
