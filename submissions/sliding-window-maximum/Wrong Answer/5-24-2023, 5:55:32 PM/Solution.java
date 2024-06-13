// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int[] res = new int[len-k+1];
        
        int idx = 0;
        
        for(int i=0; i<len; i++){
            
            int curr = nums[i];
            
            while(!dq.isEmpty() && curr >= nums[dq.peekLast()]){
                dq.removeLast();
            }
            
            dq.offer(i);
            
            if(i>=k-1){
                res[idx++] = nums[dq.peek()];
            }
            
            if(dq.peek() > i+k){
                dq.poll();
            }
        }
        return res;
        
    }
}