// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        
        return helper(s, 0);
    }
    
    private int helper(String s, int idx){
        
        int len = s.length();
        
        if(idx==len) return 1;
        if(s.charAt(idx)=='0') return 0; //invalid
        
        int res = helper(s, idx+1);
        
        if(idx<=len-2 && Integer.parseInt(s.substring(idx, idx+2))<=26){
            res += helper(s, idx+2);
        }
        
        return res;
        
    }
}