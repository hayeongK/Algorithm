import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    static int nalpha, r, maxorder;
	static List<Character> alphas;
	static List<Character>[] order;
	static List<String> answer = new ArrayList<>();
	static char[] selected;
    public String[] solution(String[] orders, int[] course) {
        // order 속 모든 알파벳 찾기 - 조합만들기 - 모든 손님으로부터 확인
    	order = new ArrayList[orders.length];
    	alphas = new ArrayList<>(); // 주문에 있는 모든 알파벳
    	
    	for(int i=0; i<orders.length; i++) { // 문자열을 글자 하나씩 리스트로
    		order[i] = new ArrayList<>();
    		for(int j=0; j<orders[i].length();j++) {
    			char temp = orders[i].charAt(j);
    			order[i].add(temp);
    			if(!alphas.contains(temp)) alphas.add(temp);
    		}
    	}
        Collections.sort(alphas);
    	
    	nalpha = alphas.size();
    	for(int c=0; c<course.length; c++) {
    		r = course[c];
    		selected = new char[r];
    		maxorder = 0;
    		comb(0, 0);
    	}
    	
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

	private static void comb(int cnt, int start) {
		if(cnt == r) {

			whoHave();
			return;
		}
		
		for(int i=start; i<nalpha; i++) {
			selected[cnt] = alphas.get(i);
			comb(cnt+1, i+1);
		}
	}

	private static void whoHave() {
		int cnt=0;
		for(int i=0; i<order.length; i++) { // 한 사람의 주문당
			boolean have = true;
			for(int s=0; s<selected.length; s++) { // 코스가 있는지
				if(!order[i].contains(selected[s])) {
					have = false;
					break;
				}
			}

			if(have) cnt++;
		}

		if(cnt>1) {
			if(cnt==maxorder) {
				String s = "";
				for(int i=0; i<selected.length; i++) s += selected[i];
				answer.add(s);
			} else if(cnt>maxorder) { // 있던거 삭제 후 추가
				String s = "";
				for(int i=0; i<selected.length; i++) s += selected[i];
				while(!answer.isEmpty() && answer.get(answer.size()-1).length()==s.length()) {
					answer.remove(answer.size()-1);
				}
				answer.add(s);
				maxorder = cnt;
			}
		}
	}
}