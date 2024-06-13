// https://leetcode.com/problems/make-array-non-decreasing-or-non-increasing

class Solution {
    public static int convertArray(int[] nums) {
        int n = nums.length;
        int res1 = 0;
        int res2 = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty() && maxHeap.peek() >= nums[i]) {
                res1 += maxHeap.peek() - nums[i];
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
            if (!minHeap.isEmpty() && minHeap.peek() <= nums[i]) {
                res2 += nums[i] - minHeap.peek();
                minHeap.poll();
                minHeap.add(nums[i]);
            }
            maxHeap.add(nums[i]);
            minHeap.add(nums[i]);
        }

        return Math.min(res1, res2);
    }
}