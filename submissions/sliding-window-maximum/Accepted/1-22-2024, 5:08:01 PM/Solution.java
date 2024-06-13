// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] res = new int[len-k+1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[i])
                dq.pollLast();
            
          
           
            dq.offerLast(i);
            
              // System.out.println(i + " " + dq);
            
            if(i-k+1>=0){
                res[i-k+1] = nums[dq.peek()];
            }
            
            while(!dq.isEmpty() && dq.peek()<=i-k+1){
                dq.poll();
            }
            
            
        }
        
        return res;
        
    }
}