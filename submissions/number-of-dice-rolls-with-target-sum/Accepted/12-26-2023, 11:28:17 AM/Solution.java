// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {

    int M = (int) 1e9+7;

    HashMap<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int n, int k, int target) {

        if(target<n || target >n*k ) return 0;
        if(n ==1) return (target <= k) ? 1 : 0;

        String key = "" + n + "_" + k + "_" +target;
        if(memo.containsKey(key)) return memo.get(key);
        int sum = 0 ;
        for(int i=1; i<=k; i++){
            sum += numRollsToTarget(n-1, k, target-i);
            sum %= M;
        }
        memo.put(key, sum);
       
        return sum;
    }

}