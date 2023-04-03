class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknown = 0;
        int same = 0;
        for(int i=0; i<6; i++) {
        	if(lottos[i] == 0) unknown++;
        	else {
        		for(int j=0; j<6; j++) {
        			if(win_nums[j] == lottos[i]) {
        				same++;
        				break;
        			}
        		}
        	}
        }
        int highest = (same+unknown > 1)? 7-same-unknown: 6;
        int lowest = (same > 1)? 7-same: 6;
        return new int[] {highest, lowest};
    }
}