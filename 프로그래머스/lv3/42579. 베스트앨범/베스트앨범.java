import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static class Music implements Comparable<Music>{
		int no;
		int nplaying;
		public Music(int no, int nplaying) {
			this.no = no;
			this.nplaying = nplaying;
		}
		@Override
		public int compareTo(Music o) {
			if(this.nplaying == o.nplaying) return this.no-o.no;
			return o.nplaying- this.nplaying ;
		}
	}
	static class Genre implements Comparable<Genre> {
		int no;
		int nplaying;
		public Genre(int no, int nplaying) {
			this.no = no;
			this.nplaying = nplaying;
		}
		@Override
		public int compareTo(Genre o) {
			return o.nplaying - this.nplaying;
		}
	}
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genremap = new HashMap<>();
    	HashMap<Integer, Integer> nplayings = new HashMap<>();
    	List<List<Music>> musics = new ArrayList<>();
    	
    	int ngenre = 0;
    	for(int i=0; i<genres.length; i++) {
    		if(genremap.containsKey(genres[i])) {
    			int num = genremap.get(genres[i]);
    			nplayings.replace(num, nplayings.get(num)+plays[i]);
    			Music m = new Music(i, plays[i]);
    			musics.get(num).add(m);
    		}
    		else {
    			genremap.put(genres[i], ngenre);
    			nplayings.put(ngenre++, plays[i]);
    			List<Music> temp = new ArrayList<>();
    			Music m = new Music(i, plays[i]);
    			temp.add(m);
    			musics.add(temp);
    		}
    	}
    	
    	for(int i=0; i<musics.size(); i++) {
    		Collections.sort(musics.get(i));
    	}
    	
    	List<Genre> genreList = new ArrayList<>();
    	for(Map.Entry<Integer, Integer> entry : nplayings.entrySet()) {
    		Genre g = new Genre(entry.getKey(), entry.getValue());
    		genreList.add(g);
    	}
    	Collections.sort(genreList);
    	
    	List<Integer> order = new ArrayList<>();
        for(Genre g: genreList) {
        	for(int i=0; i<Math.min(2, musics.get(g.no).size()); i++) {
        		order.add(musics.get(g.no).get(i).no);
        	}
        }
        
        int[] answer = new int[order.size()];
        for(int i=0; i<order.size(); i++) answer[i] = order.get(i); 
        return answer;
    }
}