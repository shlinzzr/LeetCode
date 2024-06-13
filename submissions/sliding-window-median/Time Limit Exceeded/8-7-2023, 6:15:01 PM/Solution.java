// https://leetcode.com/problems/sliding-window-median

class Solution {
   public double[] medianSlidingWindow(int[] nums, int k) {
       
       int len = nums.length;
       double[] result = new double[len - k + 1];
       
       int j=0;
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       
       for (int i = 0; i < len; i++) {
            minHeap.offer(nums[i]);
            maxHeap.offer(minHeap.poll());
           
            if(maxHeap.size()>minHeap.size()) minHeap.offer(maxHeap.poll());
            if (minHeap.size() + maxHeap.size() == k) {
                result[j]= (minHeap.size()==maxHeap.size() ) ?(double)((long)minHeap.peek()+(long)maxHeap.peek())/2:(double) minHeap.peek();
                if (!minHeap.remove(nums[j])) maxHeap.remove(nums[j]);
                j++;
            }
        }
        return result;
    }
}