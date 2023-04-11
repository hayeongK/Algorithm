import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    static class Car implements Comparable<Car>{
		String num;
		int time;
		
		public Car(String num, int time) {
			super();
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Car o) {
			return this.num.compareTo(o.num);
		}
	}
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
    	HashMap<String, Integer> times = new HashMap<>();
    	HashMap<String, Integer> in = new HashMap<>();
    	for(String rcd: records) { // 누적 시간 기록
    		st = new StringTokenizer(rcd);
    		String[] temp = st.nextToken().split(":");
    		int curtime = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    		String carn = st.nextToken();
    		String inout = st.nextToken();
    		
    		if(inout.equals("IN")) {
    			in.put(carn, curtime);
    		} else {
    			times.put(carn, times.getOrDefault(carn, 0)+(curtime-in.get(carn)));
    			in.remove(carn);
    		}
    	}
    	for(Map.Entry<String, Integer> elem : in.entrySet()) { // out 없는 차 시간 처리
    		times.put(elem.getKey(), times.getOrDefault(elem.getKey(), 0)+(1439-elem.getValue()));
    	}
    	
    	// 리스트로 바꾸고 정렬
    	List<Car> cars = new ArrayList<>();
    	for(Map.Entry<String, Integer> elem : times.entrySet()) {
    		Car car = new Car(elem.getKey(), elem.getValue());
    		cars.add(car);
    	}
    	Collections.sort(cars);
    	
    	// 요금 계산
        int[] answer = new int[cars.size()];
        for(int i=0; i<cars.size(); i++) {
        	Car car = cars.get(i);
        	if(car.time > fees[0]) {
        		answer[i] = fees[1] + (car.time-fees[0])/fees[2]*fees[3] + (((car.time-fees[0])%fees[2]==0)? 0 : fees[3]);
        	} else {
        		answer[i] = fees[1];
        	}
        }
        
        return answer;
    }
}