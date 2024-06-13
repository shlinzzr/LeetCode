// https://leetcode.com/problems/constrained-subsequence-sum

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int len = nums.length;
        Deque<int[]> dq = new ArrayDeque<>(); // idx, total
        //[10,2,-10,5,20], k = 2

        int res = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){

            int total = nums[i] + (!dq.isEmpty() ?  dq.peek()[1] : 0);
            res = Math.max(res, total);
            
            while(!dq.isEmpty() && total > dq.peekLast()[1]){
                dq.pollLast();
            }

            while(!dq.isEmpty() && i-dq.peek()[0]>=k){
                dq.poll();
            }

            if(total>0)
                dq.offer(new int[]{i, total});
        }

        return res;
    }
}