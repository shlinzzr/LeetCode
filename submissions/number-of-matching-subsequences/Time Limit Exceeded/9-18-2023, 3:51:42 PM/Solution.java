// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        
        for(String w : words){
            if(isSub(s, w))
                cnt++;
        }
        
        return cnt;
        
        
    }
    
    private boolean  isSub(String a, String b){
        
        // find b is subseq of a
        
        int len = a.length();
        int idx = 0;
        
        for(int i=0; i<len; i++){
            
            if(a.charAt(i)==b.charAt(idx)){
                idx++;
            }
            
            if(idx==b.length())
                return true;
        }
        
        return false;
        
    }
    
}