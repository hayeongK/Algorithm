import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        List<String> ids = new ArrayList<>();
		List<Integer> sentences = new ArrayList<>();
		HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>(); // 아이디별 인덱스 저장
		HashMap<String, String> names = new HashMap<String, String>();
		
		for(String rd : record) {
			String[] rds = rd.split(" ");
			
			if(rds[0].equals("Enter")) {
				if(!names.containsKey(rds[0])) {
					names.put(rds[1], rds[2]);
					List<Integer> temp = new ArrayList<>();
					map.put(rds[1], temp);
				}
				map.get(rds[1]).add(ids.size());
				ids.add(rds[1]);
				sentences.add(0);
			} else if(rds[0].equals("Leave")) {
				map.get(rds[1]).add(ids.size());
				ids.add(rds[1]);
				sentences.add(1);
			} else {
				for(int pos: map.get(rds[1])) {
					names.replace(rds[1], rds[2]);
				}
			}
		}
		
		String[] answer = new String[ids.size()];
		for(int i=0; i<ids.size(); i++) {
			if(sentences.get(i) == 0) {
				answer[i] = names.get(ids.get(i)) + "님이 들어왔습니다.";
			} else answer[i] = names.get(ids.get(i)) + "님이 나갔습니다.";
		}
        return answer;
    }
}