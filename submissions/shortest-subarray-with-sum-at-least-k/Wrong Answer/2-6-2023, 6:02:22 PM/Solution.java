// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        
        //concept https://www.youtube.com/watch?v=HeFW6EPBGBg
        
        int len  = nums.length;
        int min = len;
        long[] presum = new long[len+1];
        
        for(int i=0; i<len ; i++){
            presum[i+1] = presum[i] + nums[i];
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && presum[i]-presum[dq.getFirst()]>=k ) // 已配對成功的拉掉
                min = Math.min(min, i-dq.pollFirst());
            
            while(!dq.isEmpty() && presum[i]<=presum[dq.getLast()])  // 比curr 還大的也直接拉掉
                dq.pollLast();
            
            dq.addLast(i);
        }
        
        return min<=len? min : -1;
        
            
    }
}