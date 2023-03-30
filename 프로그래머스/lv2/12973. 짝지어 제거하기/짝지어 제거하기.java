import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
		for(int i=s.length()-1; i>0; i--) stack.push(s.charAt(i));
		Stack<Character> temp = new Stack<>();
		temp.push(s.charAt(0));
		while(!stack.isEmpty()) {
			while(stack.peek() == temp.peek()) {
				stack.pop();
				temp.pop();
				if(stack.isEmpty() || temp.isEmpty()) break;
			}
			if(!stack.isEmpty()) temp.push(stack.pop());
		}
        return temp.isEmpty()? 1: 0;
    }
}