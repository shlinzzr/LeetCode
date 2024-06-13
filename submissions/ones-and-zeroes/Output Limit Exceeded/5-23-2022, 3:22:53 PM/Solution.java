// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [] ms = new int[strs.length];
        int [] ns = new int[strs.length];
        for(int i =0; i<strs.length;++i){
            String s = strs[i];
            for(int j=0; j<s.length();++j){
                char c = s.charAt(j);
                if(c=='0')++ms[i];
                else ++ns[i];
            }
            
             System.out.println("i="+ i +" ms[i]="+ms[i] +"\t ns[i]="+ns[i]);
        }
        
 
        
        int [][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=0; i<ms.length;++i){
              System.out.println( "i="+i);
            
            for(int mm = m; mm>=ms[i];--mm){
                for(int nn=n; nn>=ns[i];--nn){
  
                    System.out.println("   dp["+mm+"]["+nn+"]=" +dp[mm][nn] + "\t dp["+mm+"-" + ms[i] + "][" +nn+"-" +ns[i] + "]="+dp[mm-ms[i]][nn-ns[i]] );
                   
                    dp[mm][nn]=Math.max(dp[mm][nn],dp[mm-ms[i]][nn-ns[i]]+1);
                }
            }
        }
        return dp[m][n];
    }
}
