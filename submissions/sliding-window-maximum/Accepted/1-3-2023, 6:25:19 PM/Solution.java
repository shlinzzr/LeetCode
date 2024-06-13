// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Deque => Decresing Queue
        
        int n = nums.length, j = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.
        for (int i = 0; i < n; i++) {
            // Eliminate elements less or equal to nums[i]
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            
            // Push index of current nums[i] to the deque
            dq.addLast(i);
            
            // if reach enough range size k -> add the result
            if (i + 1 >= k) ans[j++] = nums[dq.peekFirst()]; 
            
            // remove the last element of range k
            if (i - dq.peekFirst() + 1 >= k) dq.removeFirst(); 
        }
        return ans;
    }
}