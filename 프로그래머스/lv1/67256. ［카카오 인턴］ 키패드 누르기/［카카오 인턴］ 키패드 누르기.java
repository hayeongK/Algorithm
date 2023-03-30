import java.util.HashMap;

class Solution {
    static String answer = "";
	static HashMap<Integer, Position> map;
	static int leftr, leftc, rightr, rightc;
    public static class Position {
		int row;
		int col;
		public Position(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
    public String solution(int[] numbers, String hand) {
        map = new HashMap<>();
		for(int i=0; i<9; i++) { // 숫자별 자리
			map.put(i+1, new Position(i/3, i%3));
		}
		map.put(0, new Position(3, 1));
		leftr = 3;
		leftc = 0;
		rightr = 3;
		rightc = 2;
		
        for(int num: numbers) {
        	if(num==1 || num == 4 || num==7) action(0, num);
        	else if(num==3 || num==6 || num==9) action(1, num);
        	else {
        		int leftDiff = Math.abs(map.get(num).row - leftr) + Math.abs(map.get(num).col - leftc);
        		int rightDiff = Math.abs(map.get(num).row - rightr) + Math.abs(map.get(num).col - rightc);
        		if(leftDiff < rightDiff) action(0, num);
        		else if(leftDiff > rightDiff) action(1, num);
        		else {
        			if(hand.equals("left")) action(0, num);
        			else action(1, num);
        		}
        	}
        }
        return answer;
    }
    
    public static void action(int hand, int num) {
		if(hand == 0) { // 왼손
			answer += "L";
			leftr = map.get(num).row;
    		leftc = map.get(num).col;
		} else {
			answer += "R";
			rightr = map.get(num).row;
    		rightc = map.get(num).col;
		}
	}
}