// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] presum = new long[len+1];

        for(int i=0; i<len; i++){
            presum[i+1] =  nums[i] + presum[i];
        }

        // int min = Integer.MAX_VALUE;
        int min = len+1;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<=len; i++){ // 0~len

            while(!dq.isEmpty() && presum[i] - presum[dq.peek()]>=k){
                min = Math.min(min, i-dq.poll());
            }

            while(!dq.isEmpty() && presum[i]<dq.peekLast()){
                dq.pollLast();
            }

            dq.offer(i);

        }
        return min==len+1 ? -1 : min;
    }

 
}