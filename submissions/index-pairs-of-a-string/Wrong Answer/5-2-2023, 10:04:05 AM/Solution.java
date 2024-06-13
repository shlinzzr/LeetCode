// https://leetcode.com/problems/index-pairs-of-a-string

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        int len = words.length;
        
        int[][] res = new int[len][2];
        
        for(int i=0; i<len; i++){
            String w = words[i];
            
            int idx = text.indexOf(w);
            
            
            res[i] = new int[]{idx, idx+ w.length()-1};
            
        }
        
        return res;
    }
}