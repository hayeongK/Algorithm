class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<s.length()/2+1; i++) {
        	int slen = 0;
        	int same = 0;
        	String part = s.substring(0, i);
        	for(int start=i; start+i<s.length()+1; start+=i) {
        		String temp = s.substring(start, start+i);
        		if(part.equals(temp)) {
        			same += 1;
        		} else {
        			if(same == 0) slen += i;
        			else {
        				slen += i+String.valueOf(same+1).length();
        				same = 0;
        			}
        		}
        		part = temp;
        	}
        	if(same == 0) slen += i;
			else {
				slen += i + String.valueOf(same+1).length();
				same = 0;
			}
        	slen += s.length()%i;
        	answer = Math.min(answer, slen);
        }
        if(s.length() == 1) answer = 1;
         return answer;
    }
}