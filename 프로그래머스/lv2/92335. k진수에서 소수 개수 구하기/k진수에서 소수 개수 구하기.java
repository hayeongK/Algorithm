import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
    	String knum = changeNumber(n, k);
    	StringTokenizer st = new StringTokenizer(knum, "0");
    	while(st.hasMoreTokens()) {
    		long num = Long.parseLong(st.nextToken());
    		if(isPrime(num)) answer++;
    	}

        return answer;
    }


	private static boolean isPrime(long num) {
		if(num == 2) return true;
		for(int i=2; i<Math.sqrt(num)+1; i++) {
			if(num%i == 0) return false;
		}
        if(num == 1) return false;
		return true;
	}

	private static String changeNumber(int n, int k) {
		String result = "";
		while(n>0) {
			result = String.valueOf(n%k) + result;
			n /= k;
		}
		return result;
	}
}