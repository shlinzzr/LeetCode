// https://leetcode.com/problems/sliding-window-median

class Solution {
   public double[] medianSlidingWindow(int[] nums, int k) {
       double[] result = new double[nums.length - k + 1];
       int j=0;
       PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Integer> hi = new PriorityQueue<>();
       for (int i = 0; i < nums.length; i++) {
            lo.add(nums[i]);
            hi.add(lo.poll());
            if(hi.size()>lo.size()) lo.add(hi.poll());
            if (lo.size() + hi.size() == k) {
                result[j]=lo.size()==hi.size()?(double)((long) lo.peek()+(long)hi.peek())/2:(double) lo.peek();
                if (!lo.remove(nums[j])) hi.remove(nums[j]);
                j++;
            }
        }
        return result;
    }
}