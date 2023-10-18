import java.util.*;

class Solution {
    public static class Num implements Comparable<Num> {
        String n;
        public Num(int n) {
            this.n = String.valueOf(n);
        }
        @Override
        public int compareTo(Num o) {
            return (o.n + this.n).compareTo(this.n + o.n);
        }
    }
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int n: numbers) {
            pq.add(new Num(n));
        }
        
        if((pq.peek().n).equals("0")) return "0";
        
        while(!pq.isEmpty()) {
            answer += pq.poll().n;
        }
        return answer;
    }
}