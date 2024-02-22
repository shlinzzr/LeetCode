// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {

    int M = (int) 1e9+7;
    // dp top down
    int[][] dp ;


    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        return recur(n, k, target);
    }

    private int recur(int n, int k, int target) {
        if( n==0 && target==0) return 1;
        if( n==0 || target<=0) return 0;

        if(dp[n][target]!=-1) return dp[n][target]%M;
        int sum = 0; 
        for(int i=1; i<=k; i++){
            sum += recur(n-1, k, target-i);
            sum %= M;
        }

        dp[n][target] = sum;
        return sum;
    }


    // recur + memo : 65ms
    // HashMap<String, Integer> memo = new HashMap<>();

    // public int numRollsToTarget(int n, int k, int target) {

    //     if(target<n || target >n*k ) return 0;
    //     if(n ==1) return (target <= k) ? 1 : 0;

    //     String key = "" + n + "_" + k + "_" +target;
    //     if(memo.containsKey(key)) return memo.get(key);
    //     int sum = 0 ;
    //     for(int i=1; i<=k; i++){
    //         sum += numRollsToTarget(n-1, k, target-i);
    //         sum %= M;
    //     }
    //     memo.put(key, sum);
       
    //     return sum;
    // }

}