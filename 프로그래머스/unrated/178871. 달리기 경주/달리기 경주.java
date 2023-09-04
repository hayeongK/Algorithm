import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> names = new HashMap<>(); 
        Map<Integer, String> order = new HashMap<>();
        
        for(int i=0; i < players.length; i++) {
            names.put(players[i], i);
            order.put(i, players[i]);
        }
        
        int calledNum = 0;
        for(int i=0; i<callings.length; i++) {
            calledNum = names.get(callings[i]);
            
            String name = order.get(calledNum-1); // 앞에 있던
            order.put(calledNum, name);
            names.put(name, calledNum);            
            
            names.put(callings[i], calledNum-1);
            order.put(calledNum-1, callings[i]);
        }
        
        for(int i=0; i<players.length; i++) {
            answer[i] = order.get(i);
        }
        
        return answer;
    }
}