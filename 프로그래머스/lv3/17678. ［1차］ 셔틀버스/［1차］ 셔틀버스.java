import java.util.PriorityQueue;

class Solution {
    static class Time implements Comparable<Time> {
		int hour;
		int minute;
		
		
		public Time(int hour, int minute) {
			super();
			this.hour = hour;
			this.minute = minute;
		}

		public void add(int m) {
			if(this.minute + m < 60) minute += m;
			else {
				hour += 1;
				minute = (minute + m)%60;
			}
		}
		
		public void minus() {
			if(minute == 0) {
				this.hour -= 1;
				minute = 59;
			} else this.minute -= 1;
		}

		@Override
		public String toString() {
			return "Time [hour=" + hour + ", minute=" + minute + "]";
		}

		@Override
		public int compareTo(Time o) {
			if(this.hour == o.hour) return this.minute - o.minute;
			return this.hour - o.hour;
		}
	}
    public String solution(int n, int t, int m, String[] timetable) {
        Time cur = new Time(9, 0);
    	
    	PriorityQueue<Time> pq = new PriorityQueue<>();
    	for(String s: timetable) {
    		String[] ss = s.split(":");
    		Time time = new Time(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
    		pq.add(time);
    	}
    	
    	// 마지막 전 셔틀까지 보내기
    	for(int i=0; i<n-1; i++) {
    		for(int j=0; j<m; j++) {
    			if(!pq.isEmpty() && cur.compareTo(pq.peek()) >= 0) pq.poll();
    		}
    		cur.add(t);
    	}
    	
    	Time before = null;
    	// 마지막 셔틀
    	if(pq.size() >= m) {
    		for(int i=0; i<m; i++) {
    			if(pq.isEmpty()) break;
    			if(cur.compareTo(pq.peek())>=0) before = pq.poll();
    		}
    	}
    	
    	String answer = "";
		if(before != null && before.compareTo(cur)<=0) {
			cur = before;
			cur.minus();
		}
		if(cur.hour < 10) answer += "0";
    	answer += (cur.hour + ":");
    	if(cur.minute < 10) answer += ("0"+cur.minute);
    	else answer += cur.minute;
    	
        return answer;
    }
}