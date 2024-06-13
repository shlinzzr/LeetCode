// https://leetcode.com/problems/jump-game-vi

class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int max= nums[0];
        Deque<int[]> dq = new ArrayDeque<>(); // idx, val
        for(int i=0; i<len; i++){

            while(!dq.isEmpty() && dq.peek()[0]<i-k){
                dq.poll();
            }
            
            max = dq.isEmpty() ? nums[i] : dq.peek()[1]+nums[i];

            while(!dq.isEmpty() && dq.peekLast()[1]<max){
                dq.pollLast();
            }

            dq.offer(new int[]{i, max});

          


        }

        return max;



        // dp : O(NK) 
        // int[] dp = new int[len+1]; // the max score when meet i step;
        // for(int i=1; i<=len; i++){
        //     dp[i] = nums[i-1];
        //     for(int j=1; j<=k && j+k<len; j++){
        //         dp[i] = Math.max(dp[i], dp[j] + nums[i]) ...
        //     }
        // }
    }
}