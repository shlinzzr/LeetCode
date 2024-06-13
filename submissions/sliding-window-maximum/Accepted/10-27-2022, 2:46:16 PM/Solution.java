// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int[] res = new int[len-k+1];
        int ri=0;
        Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			
            // remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				res[ri++] = nums[q.peek()];
			}
		}
		return res;
        
        
    }
}