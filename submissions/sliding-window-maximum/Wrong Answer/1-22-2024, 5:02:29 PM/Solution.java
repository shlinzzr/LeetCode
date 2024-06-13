// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] res = new int[len-k+1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && nums[dq.peek()]<= nums[i])
                dq.pollLast();
            
            dq.offer(i);
            
            if(i-k+1>=0){
                res[i-k+1] = nums[dq.peek()];
            }
            
            if(dq.peek()<=i-k+1){
                dq.poll();
            }
            
        }
        
        return res;
        
    }
}