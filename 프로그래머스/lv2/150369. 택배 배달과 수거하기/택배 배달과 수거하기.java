import java.util.Arrays;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delidx = -1;
        int pickidx = -1;
        int[] del = new int[n]; // 이전 집 중 0이 아닌 집의 인덱스
        int[] pick = new int[n];
        Arrays.fill(del, -1);
        Arrays.fill(pick, -1);
        for(int i=0; i<n; i++) {
        	if(deliveries[i] != 0) {
        		del[i] = delidx;
        		delidx = i;
        	}
        	if(pickups[i] != 0) {
        		pick[i] = pickidx;
        		pickidx = i;
        	}
        }
        
        while(delidx!=-1 || pickidx!=-1) {
        	int dis = Math.max(delidx, pickidx);
        	
        	int space = cap;
        	while(space != 0 && delidx!=-1) {
        		if(deliveries[delidx] <= space) { // 현재 집에 배달 완료되는 경우
        			space -= deliveries[delidx];
        			deliveries[delidx] = 0;
        			delidx = del[delidx];
        		} else {
        			deliveries[delidx] -= space;
        			space = 0;
        		}
        	}
        	
        	space = cap;
        	while(space != 0 && pickidx!=-1) {
        		if(pickups[pickidx] <= space) { // 현재 집에 배달 완료되는 경우
        			space -= pickups[pickidx];
        			pickups[pickidx] = 0;
        			pickidx = pick[pickidx];
        		} else {
        			pickups[pickidx] -= space;
        			space = 0;
        		}
        	}
        	
        	answer += (dis+1)*2;
        }
        return answer;
    }
}
