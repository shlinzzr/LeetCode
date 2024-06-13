// https://leetcode.com/problems/sliding-window-median

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        //integer.compare prevents overflow
        Comparator<Integer> comp = (a, b)  ->  nums[a] != nums[b] ?  Integer.compare(nums[a], nums[b]) : a - b;
        //the max and min sets store the index and are ordered by values at these indices. If 2 values are equal then the order depends on which one was seen first
        //  desc with smaller values
        // TreeSet<Integer> maxset =  new TreeSet<>(comp.reversed());
        // //  asc with large values
        // TreeSet<Integer> minset =  new TreeSet<>(comp);
        
        PriorityQueue<Integer> maxset = new PriorityQueue<>(comp.reversed());
        PriorityQueue<Integer> minset = new PriorityQueue<>(comp);
        

        for (int i = 0; i < k; i++) 
            addIndex(i, maxset, minset);
        
        result[0] = getMedian(nums, maxset, minset);

        int r = 1;
        for (int i = k; i < nums.length  ; i++) {
            if( ! maxset.remove(i-k)) minset.remove(i-k);
            addIndex(i, maxset, minset);
            result[r++] = getMedian(nums, maxset, minset);
        }
        return result;
    }

    // private double getMedian(int[] nums, TreeSet<Integer> maxset, TreeSet<Integer> minset) {
    private double getMedian(int[] nums, PriorityQueue<Integer> maxset, PriorityQueue<Integer> minset) {
        return maxset.size() == minset.size() ?    ((double) nums[maxset.peek()] + (double)nums[minset.peek()]) * 0.5 : nums[minset.peek()];
    }


    // private void addIndex(int idx, TreeSet<Integer> maxset, TreeSet<Integer> minset) {
    private void addIndex(int idx, PriorityQueue<Integer> maxset, PriorityQueue<Integer> minset) {
        // minset.add(idx);
        // maxset.add(minset.pollFirst());
        // if(maxset.size() > minset.size())  minset.add(maxset.pollFirst());
        
        minset.offer(idx);
        maxset.offer(minset.poll());
        if(maxset.size()>minset.size()) minset.offer(maxset.poll());
    }

}