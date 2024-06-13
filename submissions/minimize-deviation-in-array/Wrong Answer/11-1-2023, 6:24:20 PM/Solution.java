// https://leetcode.com/problems/minimize-deviation-in-array

class Solution {
    public int minimumDeviation(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        int dev = nums[len-1]-nums[0];
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 2 == 0) {
                pq.offer(n);
                min = Math.min(min, n);
            } else {
                pq.offer(n * 2);
                min = Math.min(min, n * 2);
            }
        }
        
        // System.out.println(pq+ " min=" + min);     
        
        while(!pq.isEmpty()){
            int p = pq.poll();

            dev = Math.min(dev, p-min);
            
            if(p%2==0){
                pq.offer(p/2);
                min = Math.min(min, p/2);
            } else{
                // break;
            }
        }
        
        return dev;
    }
}