// https://leetcode.com/problems/design-a-leaderboard

class Leaderboard {

    HashMap<Integer, Integer> map ; //id, score
    TreeMap<Integer, Set<Integer>> tmap; // score, cnt
    
    public Leaderboard() {
        map = new HashMap<>();
        tmap = new TreeMap<>( Collections.reverseOrder());
        
    }
    
    public void addScore(int playerId, int score) {
        int prescore = map.getOrDefault(playerId, 0);
        
        reset(playerId);
        
        map.put(playerId, score+prescore);
        
        Set<Integer> pset = tmap.getOrDefault(score+prescore, new HashSet<>());
        pset.add(playerId);
        tmap.put(score+prescore, pset);
        
    }
    
    public int top(int K) {
        
        int res = 0;
        int cnt =0;
        for(Map.Entry<Integer, Set<Integer>> en : tmap.entrySet()){
            
            int score = en.getKey();
            int size = en.getValue().size();
            
            for(int i=0; i<size && cnt<K; cnt++){
                res+=en.getKey();
                i++;
            }
            
            // res+= en.getKey()* en.getValue().size();    
        }
        return res;
    }
    
    public void reset(int playerId) {
        
        int orgscore =-1;
        if(map.containsKey(playerId))
            orgscore = map.get(playerId);
        
        map.remove(playerId);
        
       if(orgscore!=-1 && tmap.containsKey(orgscore)){
            tmap.get(orgscore).remove(playerId);
            if(tmap.get(orgscore).size()==0)
                tmap.remove(orgscore);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */