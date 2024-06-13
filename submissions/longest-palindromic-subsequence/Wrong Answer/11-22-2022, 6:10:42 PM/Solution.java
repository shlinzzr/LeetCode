// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        int[] arr = new int[26];
        
        
        int len = s.length();
        
        
        int[] dp = new int[len+1];
        
        dp[0]=0;
        boolean single =false;
        
        for(int i=1; i<=len; i++){
            
            char ch = s.charAt(i-1);
            arr[ch-'a']++;
            
            if(arr[ch-'a']%2==1){
                dp[i] = dp[i-1];
            }
                
            else
                dp[i] = dp[i-1] +2;
        }
        
        for(int a : arr){
            if(a%2==1)
                dp[len] +=1;
        }
        
        
        return dp[len];
        
    }
}