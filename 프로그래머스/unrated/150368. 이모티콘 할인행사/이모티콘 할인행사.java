class Solution {
    static int nemotion, percent[], nplus=0, price=0, emotion[], user[][]; 
	static int per[] = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        nemotion = emoticons.length;
    	emotion = new int[nemotion];
    	for(int i=0; i<nemotion; i++) emotion[i] = emoticons[i];
    	user = new int[users.length][users[0].length];
    	for(int i=0; i<users.length; i++) {
    		for(int j=0; j<users[0].length; j++) user[i][j] = users[i][j];
    	}
    	percent = new int[nemotion];

    	perm(0);
    	
        return new int[] {nplus, price};
    	
    }

	private static void perm(int cnt) {
		if(cnt == nemotion) {
			int curprice = 0;
			int curnplus = 0;
			
			// 가격 계산
			for(int i=0; i<user.length; i++) {
				int userprice = 0;
				for(int j=0; j<nemotion; j++) {
					if(per[percent[j]] >= user[i][0]) {
						userprice += (emotion[j]*(100-per[percent[j]])*0.01);
					}
				}
				if(userprice >= user[i][1]) curnplus++;
				else curprice += userprice;
			}
			
			// 최대값이라면 변경
			if(nplus < curnplus) {
				nplus = curnplus;
				price = curprice;
			} else if(nplus == curnplus && curprice > price) {
				price = curprice;
			}
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			percent[cnt] = i;
			perm(cnt+1);
		}
		
	}
}