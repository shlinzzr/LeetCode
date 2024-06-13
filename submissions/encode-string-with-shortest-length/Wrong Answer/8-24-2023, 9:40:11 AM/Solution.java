// https://leetcode.com/problems/encode-string-with-shortest-length

class Solution {
    public String encode(String s) {
        
        // https://www.youtube.com/watch?v=B8uSIMh_fFI
        
        if(s.length()<5)
            return s;
        
        String[][] dp = new String[s.length()][s.length()];
        
        
        for(int len=1; len<=s.length(); len++){
            for(int start=1; start+len<s.length(); start++){
                
                int end = start + len-1;
                
                
                String shortest = s.substring(start, end+1);
                if(shortest.length()<5){
                    dp[start][end] = shortest;
                    continue;
                }
                
                
                int repeatPos = (shortest + shortest).indexOf(shortest, 1);
                if( repeatPos<shortest.length()){
                    shortest = String.valueOf(shortest.length()/repeatPos) + "[" + shortest.substring(0, repeatPos+1) + "]";
                }
                
                
                for(int m=start; m<end; m++){
                    if(dp[start][m].length() + dp[m+1][end].length() < shortest.length()){
                        shortest = dp[start][m] + dp[m+1][end];
                    }
                }
                
                dp[start][end]=shortest;
            }
        }
        
        return dp[0][s.length()-1];
    }
}