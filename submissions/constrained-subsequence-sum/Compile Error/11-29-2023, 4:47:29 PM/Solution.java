// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int len = nums.length;
        Deque<int[]> dq = new ArrayDeque<>(); // idx, total
        //[10,2,-10,5,20], k = 2

        int res = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            
            // if dq not empty: previous total + nums
            int total = nums[i] + (!dq.isEmpty() ?  dq.peek()[1] : 0); [i]
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