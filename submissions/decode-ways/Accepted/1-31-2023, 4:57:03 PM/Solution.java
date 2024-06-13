// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        // 1   => 1 
        // 11  => 1,1 or 11
        // 111 => 1,1,1 or 11, 1 or 1, 11
        // 1111 => 1,1,1,1 or 1,1,11 or 1,11,1 or 11,1,1 or 11,11
        
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        
        for(int i=2; i<=len; i++){
            
            if(isValid(s.substring(i-1, i)))
                dp[i]+=dp[i-1];
            
            if(isValid(s.substring(i-2, i)))
                dp[i]+= dp[i-2];
            
        }
        
        // for(int d : dp){
        //     System.out.println(d);
        // }
        
        
        return dp[len];
        
    }
    
    private boolean isValid(String s){
        
        if(s.charAt(0)=='0')
            return false;
        
        int p = Integer.parseInt(s);
        if(p<=0 || p>26)
            return false;
        return true;
        
    } 
}