// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0]);
        
      
        int h = nums.size();
        
        int max = 0;
        
        for(int i=0; i<h; i++){
            
            int val = nums.get(i).get(0);
            pq.offer(new int[]{ val, i, 0}); // val, r, c
            
            max = Math.max(max, val);
        }
        
        int left=-2000000, right=max;
        int range = max-left;
        
        while(pq.size()==h){
            
            int[] p = pq.poll();
            int v = p[0];
            int r = p[1];
            int c = p[2];

            if(max-v < range){
                range = right-v;
                left = v;
                right = max;
            }
            
            if(c+1<nums.get(r).size()){
                int val = nums.get(r).get(c+1);
                pq.offer(new int[]{val, r, c+1});
                max = Math.max(max, val);
            }
        }
        
        return new int[]{left, right};
        
        
    }
}