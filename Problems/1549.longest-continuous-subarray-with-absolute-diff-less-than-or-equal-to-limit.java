// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
     public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> dq_max = new ArrayDeque<>();
        Deque<Integer> dq_min = new ArrayDeque<>();
        int st = 0;
        int ed = 0;

        for (; ed < nums.length; ed++) {
            while (!dq_max.isEmpty() && nums[ed] > nums[dq_max.peekLast()]) 
                dq_max.pollLast();

            while (!dq_min.isEmpty() && nums[ed] < nums[dq_min.peekLast()]) 
                dq_min.pollLast();

            dq_max.offer(ed);
            dq_min.offer(ed);

            if (nums[dq_max.peek()] - nums[dq_min.peek()] > limit) {
                if (nums[dq_max.peek()] == nums[st]) dq_max.poll();
                if (nums[dq_min.peek()] == nums[st]) dq_min.poll();
                st++;
            }
            
        }
        return ed-st;
    }
}
