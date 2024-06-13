// https://leetcode.com/problems/regular-expression-matching

class Solution {
    public boolean isMatch(String s, String p) {
        
//         if(p.length()==0) return s.length()==0;
        
//         boolean firstMatch = s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        
//         if(p.length()>=2 && p.charAt(1)=='*'){
//             return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
//         }else{
            
//             return firstMatch && isMatch(s.substring(1), p.substring(1));
            
//         }
        
        
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;
        
        for(int j=2; j<=n; j++){
            if(p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-2];  // consider s==aa   p=a*
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                
                if(sc==pc || pc=='.')
                    dp[i][j] = dp[i-1][j-1];
                
                else if(pc=='*'){
                        
                    if(dp[i][j-2])
                        dp[i][j]=true;
                    
                    else if(sc==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        
        return dp[m][n];        
        
        
    }
}