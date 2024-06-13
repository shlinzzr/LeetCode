// https://leetcode.com/problems/sentence-similarity

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if(len1!=len2)
            return false;
        
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list : similarPairs){
            map.put(list.get(0),list.get(1));
        } 
        
        for(int i=0; i<len1; i++){
            String w = sentence1[i];
            if(map.containsKey(w))
                sentence1[i]=map.get(w);
            
            w = sentence2[i];
            if(map.containsKey(w))
                sentence2[i]=map.get(w);
        }        
        
        for(int i=0; i<len1; i++){
            if(!sentence1[i].equals(sentence2[i]))
                return false;
        }
        
        return true;
        
        
    }
}
