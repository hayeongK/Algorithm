import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
        // /로 튜플 나누기
    	s = s.substring(1, s.length()-1);
    	s = s.replace(",{", "/");
    	s = s.replace("{", "");
    	s = s.replace("}", "");
    	
    	List<String> ss = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	StringTokenizer st = new StringTokenizer(s, "/");
    	while(st.hasMoreTokens()) {
    		ss.add(st.nextToken());
    	}
    	
    	// 문자열 길이에 따라 정렬
    	Comparator<String> c = new Comparator<String>() {
    		public int compare(String s1, String s2) {
    			return Integer.compare(s1.length(), s2.length());
    		}
		};
    	Collections.sort(ss, c);
    	
    	for(int i=0; i<ss.size(); i++) {
    		st = new StringTokenizer(ss.get(i), ",");
    		while(st.hasMoreTokens()) {
    			int num = Integer.parseInt(st.nextToken());
    			if(!list.contains(num)) list.add(num);
    		}
    	}
    	
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}