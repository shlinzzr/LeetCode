// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int len = nums.length;

        int[] res = new int[len-k+1];

        for(int i=0; i<len; i++){
            int cur = nums[i];

            while(!dq.isEmpty() && nums[dq.peekLast()]< cur){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i-k+1<0) continue;

            res[i-k+1] = nums[dq.peek()];

            if(dq.peek()<=i-k+1){
                dq.pollFirst();
            }
        }

        return res;
        
    }
}