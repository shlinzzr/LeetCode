// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        // head  1 3 -1 -3 5 3 6 7  tail

        for(int i=0; i<len; i++){

            while(!dq.isEmpty() && nums[i]> nums[ dq.peekLast()]){
                dq.pollLast();
            }

            dq.offer(i);

            if(i-k+1>=0){
                res[i-k+1] = nums[dq.peek()];    
            }

            // i==2 peek==0
            if(dq.peek()==i-k+1)
                dq.poll();
        }

        return res;
        
    }
}