// https://leetcode.com/problems/shortest-word-distance-ii

class WordDistance {
    
    // ref : https://www.youtube.com/watch?v=BBJRj3Ku2P8
    
    
    HashMap<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        
        for(int i=0; i<wordsDict.length; i++){
            String w = wordsDict[i];
            map.putIfAbsent(w, new ArrayList<>());
            map.get(w).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int i1=0, i2=0, min=Integer.MAX_VALUE;
        while(i1<list1.size() && i2<list2.size()){
            
            int val1 = list1.get(i1);
            int val2 = list2.get(i2);
            
            min = Math.min(min, Math.abs(val1-val2));
            
            if(val1<val2 && i1<list1.size()){
                i1++;
            }else{
                i2++;
            }
        }
        
        return min;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
