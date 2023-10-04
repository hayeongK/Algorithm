import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: tangerine) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i: map.keySet()) {
            pq.offer(map.get(i));
        }
        
        while(cnt < k) {
            cnt += pq.poll();
            answer++;
        }
        
        return answer;
    }
}