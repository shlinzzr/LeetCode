// https://leetcode.com/problems/beautiful-arrangement

class Solution {

    int[] dp ;
    int cnt =0 ;
    public int countArrangement(int n) {
        dp = new int[n+1];
        // if(n<=3) return n;

        boolean[] seen = new boolean[n+1];
        dfs(n, seen, 1);
        return cnt;
    }

    private void dfs(int n, boolean[] seen, int agg){
        // if(n<=3) return n;

        if(agg==n+1){
            cnt++;
        } 

        int res = 0 ;
        for(int i=1; i<=n; i++){
            if(!seen[i] && (i%agg==0 || agg%i==0 )){
                // int newState = state | (i<<i);
                seen[i]=true;
                dfs(n, seen, agg+1);
                seen[i] = false;
            }
        }

        return ;
    }
}