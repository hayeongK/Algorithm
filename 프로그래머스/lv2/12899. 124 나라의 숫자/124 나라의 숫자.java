class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
    	
    	while(n != 0) {
    		int rem = n%3;
    		if(rem == 1) sb.append("1");
    		else if(rem == 2) sb.append("2");
    		else {
    			sb.append("4");
    			n -= 1;
    		}
    		n /= 3;
    	}
    	
        return sb.reverse().toString();
    }
}