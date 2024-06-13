// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        
        int[] dp = new int[len+1];
        
//         dp[0] = s.charAt(0)==0 ? 0 : 1;
//         dp[1] = dp[0]==0 ? 1 : 0;
        
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        
        for(int i=2; i<=len; i++){
            
            
            if(isValid(s.substring(i-1, i)))
                dp[i] += dp[i-1];
            
            if(isValid(s.substring(i-2, i)))
                dp[i] += dp[i-2];
            
        }
        
        return dp[len];
        
        
    }
    
    
    private boolean isValid(String s){
        
        if(s.charAt(0)=='0')
            return false;
        
        
        int num = Integer.parseInt(s);
        
        if(num>=0 && num<=26){
            return true;
        }
        
        return false;
    }
    
}