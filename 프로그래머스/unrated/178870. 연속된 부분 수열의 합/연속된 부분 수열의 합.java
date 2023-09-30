class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int len = sequence.length + 1;
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        while(start < n) {
            // System.out.println(start + " " + end);
            // System.out.println(sum);
            if(sum > k) {
                sum -= sequence[start++];
            } else if(sum == k) {
                if((end - start) < len) {
                    len = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start++];
            } else {
                if(end < n-1) {
                    sum += sequence[++end];
                } else sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}