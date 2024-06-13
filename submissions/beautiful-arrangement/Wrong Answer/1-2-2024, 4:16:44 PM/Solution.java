// https://leetcode.com/problems/beautiful-arrangement

class Solution {

    int[] dp ;
    int cnt =0 ;
    public int countArrangement(int n) {
        dp = new int[n+1];
        if(n<3) return n;

        return dfs(n, 0, 1);
    }

    private int dfs(int n, int state, int agg){
        if(n<3) return n;

        if(agg==n+1){
            return 0;
        } 

        int res = 0 ;
        for(int i=1; i<=n; i++){
            if( (state | (1<<i))==0 && n%agg==0){
                int newState = state | (i<<i);
                res += dfs(n, newState, agg+1);
            }
        }

        return res;
    }
}