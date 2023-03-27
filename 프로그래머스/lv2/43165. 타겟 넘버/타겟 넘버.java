class Solution {
    static int[] inputs;
	static int tg, len, answer=0;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
		inputs = new int[numbers.length];
		tg = target;
		for(int i=0; i<numbers.length; i++) inputs[i] = numbers[i];
		
		dfs(0, 0);
		
        return answer;
    }
	private static void dfs(int cnt, int val) {
		if(cnt == len) {
			if(val == tg) answer++;
			return;
		}
		dfs(cnt+1, val+inputs[cnt]);
		dfs(cnt+1, val-inputs[cnt]);
	}
}