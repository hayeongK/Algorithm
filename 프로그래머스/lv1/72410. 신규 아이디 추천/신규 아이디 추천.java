import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
    	char[] chars = new_id.toCharArray();
    	Deque<Character> chs = new LinkedList<>();
    	for(int i=0; i<chars.length; i++) {
    		if(chars[i]=='.') {
    			if(!chs.isEmpty() && chs.peekLast()=='.') continue;
    			chs.add(chars[i]);
    		}
    		else if(('a'<=chars[i]&&chars[i]<='z') || chars[i]=='-' || chars[i]=='_' || ('0'<=chars[i]&&chars[i]<='9')) {
    			chs.add(chars[i]);
    		}
    	}
    	if(!chs.isEmpty() && chs.peek()=='.') chs.poll();
    	if(!chs.isEmpty() && chs.peekLast()=='.') chs.pollLast();
    	if(chs.isEmpty()) chs.add('a');
    	
    	int size = chs.size();
    	if(size>15) {
    		for(int i=15; i<size; i++) chs.pollLast();
    		if(chs.peekLast()=='.') chs.pollLast();
    	}
    	
    	while(chs.size()<3) {
    		chs.add(chs.peekLast());
    	}
    	
    	String answer = "";
    	while(!chs.isEmpty()) answer += chs.poll();
    	
        return answer;
    }
}