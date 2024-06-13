// https://leetcode.com/problems/regular-expression-matching

class Solution {
    public boolean isMatch(String s, String p) {
        
        // 兩個分支。 a. p遇到'.' 或是 general case:直接比 
        //          b. p遇到'*' 多個 或 0個
        
        
//         if(p.length()==0) return s.length()==0;
        
//         boolean firstMatch = s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        
//         if(p.length()>=2 && p.charAt(1)=='*'){
//             return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
                        // ^^^ p match 0 個 ^^^  或  ^^^ p match s第一位, s減一位 做recur ^^^
//         }else{
        
                // match一位
//             return firstMatch && isMatch(s.substring(1), p.substring(1));  
//         }
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;
        
        //initialize有星號的部分
        for(int j=2; j<=n; j++){
            if(p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-2];  // consider s==aa   p=a*
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char char_s = s.charAt(i-1);
                char char_p = p.charAt(j-1);
                
                if(char_s==char_p || char_p=='.') // match一位
                    dp[i][j] = dp[i-1][j-1];
                
                else if(char_p=='*'){
                        
                    if(dp[i][j-2]) // p match 0 個 
                        dp[i][j]=true;
                    
                    else if(char_s==p.charAt(j-2) || p.charAt(j-2)=='.'){ // p match s第一位, 
                        dp[i][j] = dp[i-1][j];  //j不動 i減一位 做recur 下一輪再比一次
                    }
                }
            }
        }
        
        return dp[m][n];        
        
        
    }
}