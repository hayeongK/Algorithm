import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int start = 0;
    	int end = 0;
    	int cursize = Integer.MAX_VALUE;
    	int[] answer = new int[2];
    	Arrays.fill(answer, -1);
    	Set<String> set = new HashSet<>(); // 몇가지 보석인지 알기 위한 변수
    	Map<String, Integer> map = new HashMap<>(); // 현재 보석의 종류와 인덱스
    	List<Integer> index = new ArrayList<>(); // 현재 보석의 인덱스들 저장
    	for(String gem: gems) set.add(gem);
    	int ngem = set.size();
    	
    	for(int i=0; i<gems.length; i++) {
    		if(map.containsKey(gems[i])) {
    			index.remove(Integer.valueOf(map.get(gems[i])));
    			index.add(i); // 기존 인덱스 삭제 후 추가
    			if(map.get(gems[i])==start) start = index.get(0);
    			map.replace(gems[i], i);
    		} else {
    			map.put(gems[i], i);
    			index.add(i);
    		} 
    		end = i;
    		
    		if(map.size() == ngem) { // 보석 모두 모이는 경우
    			if(cursize > end-start) { // 범위가 작은 경우 저장
    				cursize = end-start;
    				answer[0] = start+1;
    				answer[1] = end+1;
    			}
    		}
    		
    	}
    	
    	if(answer[0] == -1) {
    		answer[0] = 1;
    		answer[1] = gems.length;
    	}
    	
        return answer;
    }
}