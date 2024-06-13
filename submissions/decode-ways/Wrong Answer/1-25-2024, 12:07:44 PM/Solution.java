// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        
        return helper(s, 0);
    }
    
    private int helper(String s, int idx){
        
        int len = s.length();
        
        if(idx==len) return 1;
        if(s.charAt(idx)=='0') return 0; //invalid
        
        int res=0;
        if(idx<=len-1 ){
            res += helper(s, idx+1);
        }
        
        if(idx<=len-2 && s.charAt(idx)>'0' && s.charAt(idx)<='2' && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6'){
            res += helper(s, idx+2);
        }
        
        return res;
        
    }
}