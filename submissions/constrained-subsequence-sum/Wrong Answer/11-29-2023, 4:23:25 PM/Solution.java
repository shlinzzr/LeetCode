// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] dp = new int[len];

        
        for(int i=0; i<len; i++){
            if(map.size()>k && i-k-1>=0){
                map.put(dp[i-k-1], map.get(dp[i-k-1])-1);
                if(map.getOrDefault(dp[i-k-1],0)==0)
                    map.remove(dp[i-k-1]);
            }

            dp[i] = nums[i];
            if(map.size()>0){
                dp[i] = Math.max(dp[i], nums[i]+map.lastKey());
            }

            map.put(dp[i], map.getOrDefault(dp[i],0)+1);
        }

        int res = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            res = Math.max(res, dp[i]);
        }
        return res;



    }

    // nums [a b i c d j f] 
    // subseq : [i, j] => j-i<=k, find max sum of subseq
}