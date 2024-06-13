// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if(len1!=len2) return false;
        
        Map<String, String> map = new HashMap<>();
        
        for(List<String> pair : similarPairs){
            
            String p0 = pair.get(0);
            String p1 = pair.get(1);
            
            p0 = find(p0, map);
            p1 = find(p1, map);
            
            if(!p0.equals(p1)){
                map.put(p0, p1);
            }
        }
        int len = sentence1.length;
        
        for(int i=0; i<len; i++){
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if(w1.equals(w2)) continue;
            
            w1 = find(w1, map);
            w2 = find(w2, map);
            
            if(!w1.equals(w2)) return false;
        }
        
        return true;
    }
    
    private String find(String x, Map<String, String> map){
        if(!map.containsKey(x)) map.put(x, x);
        
        return x.equals(map.get(x)) ? x : map.put(x, find(map.get(x), map));
    }
}