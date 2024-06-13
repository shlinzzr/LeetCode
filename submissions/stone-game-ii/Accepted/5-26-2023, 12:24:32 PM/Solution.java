// https://leetcode.com/problems/stone-game-ii

class Solution {
    
    int[][] dp = new int[101][101];
    int[] suf = new int[101];
    
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int M = 1;
    
        suf[n] = 0;
        for (int i=n-1; i>=0; i--)
            suf[i] = suf[i+1]+piles[i];
        
        return solve(0, 1, piles);
    }
    
    private int solve(int i, int M, int[] piles)
    {
        if (i==piles.length) return 0;
        if (dp[i][M]!=0)
            return dp[i][M];
        
        int sum = 0;
        for (int x=1; x<=2*M; x++)
        {
            if (i+x-1>=piles.length) 
                break;
            sum += piles[i+x-1];            
            dp[i][M] = Math.max(dp[i][M], sum + suf[i+x] - solve(i+x, Math.max(x,M), piles));
        }
        return dp[i][M];
    }
}