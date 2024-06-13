// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        // 題目 找max sum of subseq 其中每個相鄰element j-i<=k
        // 想法1  : dp ? => O(NK) 會超時

        // int len = nums.length;
        // int[] dp = new int[len+1]; //  the maximum sum of a non-empty subsequence of that array  ending with nums[i-1];
        // Arrays.fill(dp, Integer.MIN_VALUE/2);
        // dp[1] = nums[0];
        // for(int j=2; j<=len; j++){
        //     dp[j] = Math.max(dp[j], nums[j-1]);
        //     for(int i=j-1; j-i<=k && i>0; i--){
        //         dp[j] = Math.max(dp[j], dp[i]+nums[j-1]);
        //     }
        // }

        // int res = Integer.MIN_VALUE;
        // for(int i=1; i<=len; i++){
        //     res = Math.max(res, dp[i]);
        // }

        // return res;






        // 想法2 : sliding window maximum (lc239), monostack O(N) :
        // subarray的話想到presum(lc862)	subseq的話 直接加prev
        int len = nums.length;
        Deque<int[]> dq = new ArrayDeque<>(); // idx, total
        //[10,2,-10,5,20], k = 2

        int res = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            
            // if dq not empty: previous total + nums
            int total = nums[i] + (!dq.isEmpty() ?  dq.peek()[1] : 0); 
            res = Math.max(res, total);
            
            // remove all the smaller answer
            while(!dq.isEmpty() && total > dq.peekLast()[1]){
                dq.pollLast();
            }

            // remove the out of date idx
            while(!dq.isEmpty() && i-dq.peek()[0]>=k){
                dq.poll();
            }

            if(total>0)
                dq.offer(new int[]{i, total});
        }

        return res;
    }
}