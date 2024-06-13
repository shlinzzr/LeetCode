// https://leetcode.com/problems/find-k-th-smallest-pair-distance

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );
        
        int len = nums.length;
        
        
        for(int i=1; i<len; i++){
            pq.offer(new int[]{Math.abs(nums[i]-nums[0]), i, 0});
        }
        
        // init : (1,0), (2,0), (3,0) ....
        
        while(!pq.isEmpty() && k>1){
            
            int[] p = pq.poll();
            int val = p[0];
            int i = p[1];
            int j = p[2];
            
            if(j+1<i){
                pq.offer(new int[]{Math.abs(nums[i]-nums[j+1]), i, j+1});
            }
            
            
            k--;
            
        }
        
        return pq.peek()[0];
        
        
    }
}