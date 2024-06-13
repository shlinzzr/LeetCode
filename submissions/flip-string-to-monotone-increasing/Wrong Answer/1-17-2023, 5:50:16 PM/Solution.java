// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int len = s.length();
        /*
        dp[i][0]=idx為i時的最小0翻轉次數, dp[i][1]=idx為i時的最小1翻轉次數
        if(s[i]==0){
            dp[i][0]=dp[i-1][0] + 1 //多一個0需要翻轉
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1])  // 不需要翻轉, 只要找出前一個的最小值即可
        }
        
        
        if(s[i]==1){
            dp[i][0]=dp[i-1][0]  //不需要翻轉
            dp[i][1]=Math.min(dp[i-1][0], dp[i-1][1]) + 1 // 多一個1需要翻轉
        }
        */
        
        int zero=0, one=0;
        for(char ch : s.toCharArray()){
            if(ch=='0'){
                one = Math.min(zero, one);
                zero = zero+1;
                
            }else if(ch=='1'){
                one = Math.min(zero+1, one+1);
                zero = zero; // no change
            }
        }
        
        return Math.min(one, zero);
        
        
        
    }
}