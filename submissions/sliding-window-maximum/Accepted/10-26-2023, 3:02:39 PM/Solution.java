// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();

        int[] res = new int[len-k+1];
        for(int i=0; i<len; i++){

            int cur = nums[i];

            while(!dq.isEmpty() && nums[dq.peekLast()]<cur){
                dq.pollLast();
            }

            dq.offer(i);

            if(!dq.isEmpty() && i-dq.peek()+1>k){
                dq.poll();
            }

            if(i-k+1>=0){
                res[i-k+1]=nums[dq.peek()];
            }
        }

        return res;

    }
}