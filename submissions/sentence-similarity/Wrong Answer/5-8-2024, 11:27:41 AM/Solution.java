// https://leetcode.com/problems/sentence-similarity

class Solution {
    public boolean areSentencesSimilar(String[] sen1, String[] sen2, List<List<String>> sim) {
        int size = sim.size();
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<size;i++){
            List<String> list = sim.get(i);
            map.put(list.get(0), list.get(1));
            map.put(list.get(1), list.get(0));
        }
        
        if(sen1.length != sen2.length) return false;
        
        int len = sen1.length;
        
        for(int i=0; i<len; i++){
            
            String w1 = sen1[i];
            String w2 = sen2[i];
            
            if(w1.equals(w2)) continue;
            
            if(map.containsKey(w1) && map.get(w1).equals(w2))
                continue;
            
            if(map.containsKey(w2) && map.get(w2).equals(w1))
                continue;
            
            return false;
            
            
        }
        
        return true;
    }
    
    
}