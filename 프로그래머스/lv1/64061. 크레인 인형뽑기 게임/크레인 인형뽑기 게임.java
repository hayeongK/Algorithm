import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int line: moves) {
        	int check = 0;
        	for(int i=0; i<board.length; i++) { // 인형 찾기
        		if(board[i][line-1] != 0) {
        			check = board[i][line-1];
        			board[i][line-1] = 0;
        			break;
        		}
        	}
        	
        	if(check != 0) { // 인형이 있는 경우
        		if(!stack.isEmpty() && stack.peek() == check) { // 터뜨리기
        			stack.pop();
        			answer += 2;
        		}
        		else stack.push(check);
        	}
        }
        return answer;
    }
}