import java.util.*;

class Solution {
    static int order[], n, initial, answer;
    static boolean visited[];
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        initial = k;
        order = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        answer = -1;
        
        perm(0, dungeons);
        return answer;
    }
    
    public void explore(int[][] dungeons) {
        int remaining = initial;
        int cnt = 0;
        for(int cur: order) {
            if(remaining < dungeons[cur][0]) break;
            cnt++;
            remaining -= dungeons[cur][1];
        }
        answer = Math.max(answer, cnt);
    }
    
    public void perm(int cnt, int[][] dungeons) {
        if(cnt == n) {
            explore(dungeons);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            order[cnt] = i;
            perm(cnt+1, dungeons);
            visited[i] = false;
        }
    }
}