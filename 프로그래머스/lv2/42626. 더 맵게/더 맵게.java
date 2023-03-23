import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
        	queue.offer(scoville[i]);
        }
        while(true) {
        	int lowest = queue.poll();
        	if(lowest >= K) break;
        	if(queue.isEmpty()) {
        		answer = -1;
        		break;
        	}
        	int second = queue.poll();
        	queue.offer(lowest + second*2);
        	answer += 1;
        }
        return answer;
    }
}