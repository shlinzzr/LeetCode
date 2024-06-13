// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque(); // poll head, offer last
        
        int[] res = new int[len-k+1];
        
        
        for(int i=0; i<len; i++){
            
            int curr = nums[i];
            
            while(!dq.isEmpty() && nums[dq.peekLast()]<curr){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            
            int idx = i-k+1;
            if(idx>=0){
                res[idx] = nums[dq.peek()];
            }
            
            if(i-dq.peek()==k)
                dq.poll();
        }
        
        
        
        
        
        
        return res;
        
    }
}