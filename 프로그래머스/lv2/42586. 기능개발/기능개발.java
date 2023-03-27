import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 진행별 걸리는 날짜 계산
		int[] days = new int[progresses.length];
		for(int i=0; i<days.length; i++) {
			int cal = (100-progresses[i])/speeds[i];
			days[i] = (100-progresses[i])%speeds[i]==0?cal:cal+1;
		}
		
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		while(idx<days.length) {
			int day = days[idx];
			int first=idx;
			while(true) { // 한꺼번에 처리할 수 있는 날 계산
				idx += 1;
				if(idx==days.length) break;
				if(days[idx]>day) break;
			}
			list.add(idx-first);
		}
		
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}