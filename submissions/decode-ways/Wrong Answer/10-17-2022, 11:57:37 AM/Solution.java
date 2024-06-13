// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        // 1   => 1 
        // 11  => 1,1 or 11
        // 111 => 1,1,1 or 11, 1 or 1, 11
        // 1111 => 1,1,1,1 or 1,1,11 or 1,11,1 or 11,1,1 or 11,11
        
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[0] = 0;
        
        int prev = 0;
        for(int i=0; i<len; i++){
            
            int bonus = 0;
            int curr = Integer.valueOf(prev*10 + s.charAt(i)-'0');
            
            if((curr<=26 && prev!=0) || i==0){
                bonus=1;
            }
            
            
            
            dp[i+1] = dp[i] + bonus;
            
            prev = s.charAt(i)-'0';
        }
        
        // for(int d : dp){
        //     System.out.println(d);
        // }
        
        
        return dp[len];
        
    }
}