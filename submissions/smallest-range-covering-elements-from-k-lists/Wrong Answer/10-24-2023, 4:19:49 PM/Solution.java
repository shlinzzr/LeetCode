// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));
        
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
            int val = p[0];
            int row = p[1];
            int col = p[2];

            if(max-val < range){
                left = val;
                right = max;
                range = right-val;
            }
            
            if(col+1<nums.get(row).size()){
                int next = nums.get(row).get(col+1);
                pq.offer(new int[]{next, row, col+1});
                max = Math.max(max, next);
            }
        }
        
        return new int[]{left, right};
        
        
    }
}