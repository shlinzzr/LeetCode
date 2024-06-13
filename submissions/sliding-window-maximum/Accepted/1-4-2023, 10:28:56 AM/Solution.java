// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int j=0;
        ArrayDeque<Integer> dq = new ArrayDeque();
        
        int[] res = new int[len-k+1];
        
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
                dq.pollLast();
            
            
            // dq.offer(nums[i]);
            dq.addLast(i);
            
            if(i+1 >=k) res[j++] = nums[dq.peekFirst()];
            
            if(i-dq.peekFirst()+1>=k) dq.removeFirst();
            
            
        }
        
        return res;
        
    }
}