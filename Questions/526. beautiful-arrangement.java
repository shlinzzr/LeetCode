// https://leetcode.com/problems/beautiful-arrangement

class Solution {

    Integer[][] dp ;
    public int countArrangement(int n) {
        dp = new Integer[1<<(n+3)][n+1];
        if(n<=3) return n;

        return dfs(n, 0, 1);
        // 2 4 8 16 32 64
        // 1 2 3 4. 5. 6
    }

    private int dfs(int n, int state, int agg){

        if(agg==n+1){
            return 1;
        } 
        // System.out.println(state + " " + agg + " " + (1<<(n+2)));

        if(dp[state][agg]!=null) return dp[state][agg];

        int res = 0 ;
        for(int i=1; i<=n; i++){
            if( (state & (1<<i))==0 && (i%agg==0 || agg%i==0)){
                int newState = state | (1<<i);
                res += dfs(n, newState, agg+1);
            }
        }
        
        dp[state][agg]=res;
        return res;
    }
}