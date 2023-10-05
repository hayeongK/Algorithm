import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int i=0;
        
        while(i < ingredient.length) {
            st.push(ingredient[i++]);
            if(st.size() > 3) {
                if(st.get(st.size()-1) == 1
                   && st.get(st.size()-2) == 3
                   && st.get(st.size()-3) == 2
                   && st.get(st.size()-4) == 1
                  ) {
                    answer++;
                    for(int k=0; k<4; k++) st.pop();
                }
            }
        }
        
        return answer;
    }
}