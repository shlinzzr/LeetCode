// https://leetcode.com/problems/shortest-word-distance-iii

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int len = wordsDict.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            String w = wordsDict[i];
            
            if(w.equals(word1)){
                list1.add(i);
            }else if(w.equals(word2)){
                list2.add(i);
            }
        }
        
        int min = len;
        int i1=0, i2=0;
        
        while(i1<list1.size() && i2<list2.size()){
            
            int idx1 = list1.get(i1);
            int idx2 = list2.get(i2);
            
            if(idx1==idx2){
                if(i1<list1.size())
                    i1++;
                else i2++;
            }else if(idx1<idx2){
                
                min = Math.min(idx2-idx1, min);
                i1++;
            }else{
                
                
                min = Math.min(min, idx1-idx2);
                i2++;
            }
        }
        
        return min;
        
        
        
    }
}