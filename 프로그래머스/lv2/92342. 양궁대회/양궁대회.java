class Solution {
    static int socrediff=-1, ryan[] = new int[11], apeach[] = new int[11], answer[] = {-1};
    public int[] solution(int n, int[] info) {
        for(int i=0; i<11; i++) apeach[i] = info[10-i];
    	sub(1, n);
        return answer;
    }
    
    private static void sub(int cnt, int remaining) {
    	if(remaining == 0 || cnt==11) {
    		// 점수 계산
    		int rscore = 0, ascore=0;
    		for(int i=1;  i<11; i++) {
    			if(ryan[i] != 0) rscore += i;
    			else if(apeach[i] != 0) ascore += i;
    		}
    		
    		// 조건 확인
    		if(rscore > ascore && socrediff < (rscore-ascore)) {
    			socrediff = rscore - ascore;
    			answer = new int[11];
    			for(int i=0; i<11; i++) answer[i] = ryan[10-i];
    			if(remaining != 0) answer[10] += remaining; // 화살 남아있는 경우
    		}
    		return;
    	}
    	
    	if(remaining > apeach[cnt]) {
    		ryan[cnt] = apeach[cnt]+1;
    		sub(cnt+1, remaining - apeach[cnt]-1);
    		ryan[cnt] = 0;
    	}
    	sub(cnt+1, remaining);
    }
}