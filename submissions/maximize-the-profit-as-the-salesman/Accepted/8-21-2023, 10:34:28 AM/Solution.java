// https://leetcode.com/problems/maximize-the-profit-as-the-salesman

class Solution {
    
    // int[] dp = new int[100005];
    // public int maximizeTheProfit(int n, List<List<Integer>> offers) {
    //     int[] dp = new int[n + 1];
    //     List<List<List<Integer>>> m = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         m.add(new ArrayList<List<Integer>>());
    //     }
    //     for (List<Integer> a : offers) {
    //         m.get(a.get(1)).add(a);
    //     }
    //     for (int e = 1; e <= n; e++) {
    //         dp[e] = dp[e - 1];
    //         for (List<Integer> a : m.get(e - 1)) {
    //             dp[e] = Math.max(dp[e], dp[a.get(0)] + a.get(2));
    //         }
    //     }
    //     return dp[n];
    // }
    
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n + 1];
        List<List<List<Integer>>> m = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            m.add(new ArrayList<List<Integer>>());
        }
        for (List<Integer> a : offers) {
            m.get(a.get(1)).add(a);
        }
        // //不能用map
        // Map<Integer, int[]> map = new HashMap<>();
        // for(List<Integer> of: offers){
        //     map.put(of.get(1)+1, new int[]{of.get(0)+1, of.get(2)}); // <ed, int[]{st, gold}>
        // }
        
        for(int i=1; i<=n; i++){
            
            dp[i] = dp[i-1];
            for (List<Integer> a : m.get(i-1)) {
                 dp[i] = Math.max(dp[i], dp[a.get(0)] + a.get(2));
            }
        }
        
        return dp[n];
        
    }
    
    /* x x x x [j x x i]
    
    dp[i] = dp[j1-1] + val
            dp[j2-1] + val
            ...
            dp[i-1] (no sale = prev)
            find max*/
}