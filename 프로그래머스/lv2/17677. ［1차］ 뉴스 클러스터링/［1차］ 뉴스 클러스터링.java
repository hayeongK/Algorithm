import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
    	str2 = str2.toLowerCase();
    	HashMap<String, Integer> map1 = new HashMap<>();
    	HashMap<String, Integer> map2 = new HashMap<>();
    	
    	// 값 변별 후 (문자열, 갯수)로 추가
        for(int i=0; i<str1.length()-1; i++) {
        	String s = str1.substring(i, i+2);
        	if(isAlpha(s)) map1.put(s, map1.getOrDefault(s, 0)+1);
        }
        for(int i=0; i<str2.length()-1; i++) {
        	String s = str2.substring(i, i+2);
        	if(isAlpha(s)) map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        
        List<String> inter = new ArrayList<>();
        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        Iterator<String> iter = set1.iterator();
        while(iter.hasNext()) { // 겹치는 문자 찾기
        	String s = iter.next();
        	if(set2.contains(s)) inter.add(s);
        }
        
        int n=0; // 교집합
        int u=0; // 합집합
        for(int i=0; i<inter.size(); i++) {
        	n += Math.min(map1.get(inter.get(i)), map2.get(inter.get(i)));
        	u += Math.max(map1.get(inter.get(i)), map2.get(inter.get(i)));
        	map1.remove(inter.get(i));
        	map2.remove(inter.get(i));
        }
        
        // 나머지 더하기
        Iterator<Integer> values1 = map1.values().iterator();
        Iterator<Integer> values2 =  map2.values().iterator();
        while(values1.hasNext()) u += values1.next();
        while(values2.hasNext()) u += values2.next();
    	
        return (u==0)? 65536: (int)((float)n/(float)u*65536);
    }

	private static boolean isAlpha(String s) {
		if('a'<=s.charAt(0)&&s.charAt(0)<='z' && 'a'<=s.charAt(1)&&s.charAt(1)<='z') return true;
		return false;
	}
}