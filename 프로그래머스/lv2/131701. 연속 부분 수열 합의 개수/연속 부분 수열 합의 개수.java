import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        for(int i=0; i<n; i++) set.add(elements[i]);
        
        for(int l=2; l<n; l++) { // 길이
            int sum = 0;
            for(int i=0; i<l; i++) sum += elements[i];
            set.add(sum);
            for(int i=l; i< l + elements.length - 1; i++) { // 다음 지점
                sum -= elements[(i-l+n)%n]; // 이전 빼고
                sum += elements[i%n]; // 다음 더하고
                set.add(sum);
            }
        }
        
        return set.size() + 1;
    }
}