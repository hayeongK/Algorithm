import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    static int[] order = new int[3];
	static boolean[] selected = new boolean[3];
	static List<Long> numList = new ArrayList<>();
	static List<Integer> calList = new ArrayList<>();
	static String[] cal = {"+", "-", "*"};
	static long answer = 0;
    
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+|-|*", true);
        while(st.hasMoreTokens()) {
        	String s = st.nextToken();
        	if(isNum(s)) numList.add(Long.parseLong(s));
        	else {
        		for(int i=0; i<3; i++) {
        			if(s.equals(cal[i])) {
        				calList.add(i);
        				break;
        			}
        		}
        	}
        }
        
        setOrder(0);
        
        return answer;
    }
    private static void action() {
    	Deque<Long> nums = new LinkedList<>();;
    	Queue<Integer> cals = new LinkedList<>();
    	for(int i=0; i<calList.size(); i++) {
    		nums.add(numList.get(i));
    		cals.add(calList.get(i));
    	}
    	nums.add(numList.get(numList.size()-1));
    	
    	for(int o=0; o<3; o++) {
    		int size = cals.size();
    		for(int i=0; i<size; i++) {
    			if(cals.peek() == order[o]) {
    				long num1 = nums.poll();
    				long num2 = nums.poll();
    				nums.addFirst(calculate(order[o], num1, num2));
    				cals.poll();
    			}
    			else {
    				nums.add(nums.poll());
    				cals.add(cals.poll());
    			}
    		}
    		nums.add(nums.poll());
    	}
    	answer = Math.max(answer, Math.abs(nums.poll()));
    }
    
    private static Long calculate(long cal, long num1, long num2) {
    	if(cal == 0) {
    		return num1+num2;
    	} else if(cal == 1) {
    		return num1-num2;
    	} else {
    		return num1*num2;
    	}
	}

	private static void setOrder(int cnt) {
    	if(cnt == 3) {
    		action();
    		return;
    	}
    	
    	for(int i=0; i<3; i++) {
    		if(selected[i]) continue;
    		selected[i] = true;
    		order[cnt] = i;
    		setOrder(cnt+1);
    		selected[i] = false;
    	}
	}

	private static boolean isNum(String s) {
    	try {
    		Long.parseLong(s);
    		return true;
    	} catch(Exception e) {
    		return false;
    	}
    }
}