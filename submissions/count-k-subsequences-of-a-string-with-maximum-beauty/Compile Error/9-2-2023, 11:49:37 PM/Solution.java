// https://leetcode.com/problems/count-k-subsequences-of-a-string-with-maximum-beauty

class Solution {
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        
        int len = s.length();
        int M = (int) 1e9+7;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        
        s = "#"+s;
        
        int[][] dp = new int[len+1][k+1][26]; // 當走到地i個char的時候長度是k的max 26看用過了沒
        
        for(int i=1; i<=len; i++){
            dp[i][1] = Math.max(dp[i][1], dp[i-1][1]);
            
            for(int j=1; j<=k && j<=i; k++){
                
                char ch = s.charAt(i);
                
                if(j==1){
                    
                    for(int c=0; c<26; c++){
                       dp[i][1][c] = Math.max(dp[i-1][1][c], map.get(ch)); 
                    }
                    dp[i][1][ch-'a'] = map.get(ch);
                    continue;
                }
                
                
                if(dp[i-1][j-1][ch-'a']==0){ // 這個char還沒用過
                    
                    dp[i][j][ch-'a'] = dp[i][j-1][ch-'a']+map.get(ch);
                    
                    
                }
                
                
                if()
                
                
                dp[i][j] = 
                
                
            }
        }
        
        
        
        
        
        
    }
}