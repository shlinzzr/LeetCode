// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0]=1; // 組成0 digit only 1 way
        dp[1]=1;
        for(int i=2; i<=len; i++){ //len=2
            char ch = s.charAt(i-1);
            if(i<len){
                char nxt = s.charAt(i);
                if(nxt=='0'){
                    dp[i]=dp[i-1];
                    i++;
                    continue;
                }
            }
            
            if(ch-'0'>2){
                dp[i]=dp[i-1];
                continue;
            }
            
            if(i==len-3 && s.charAt(i+1)=='0'){
                dp[i]=dp[i-1];
                continue;
            }
            
            dp[i]=dp[i-1]*2;
            
        }
        
        return dp[len];
    }
}


// always consider 2 digits:

// i, i+1  
//     0. -> must take 2 digit
    
// 1/2  -> might be 1 digit or 2 digit

// 3+  must be only 1 digit
