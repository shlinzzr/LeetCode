// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int len = nums.size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2], b[2])
        );
        
        int max = 0;
        for(int r=0; r<len; r++){
            int val = nums.get(r).get(0);
            int[] en = new int[]{r, 0, val};
            pq.offer(en);
            max = Math.max(max, val);
        }
        
        int st = -200000, ed=max, range = 200000+max;
        
        while(pq.size()==len){
            
            int[] p = pq.poll();
            int row = p[0];
            int col = p[1];
            int val = p[2];
            
            if(max-val<range){
                st=val;
                ed=max;
                range = max-val;
            }
            
            if(col +1 <nums.get(row).size()){
                
                int next = nums.get(row).get(col+1);
                int[] en = new int[]{row, col+1, next};
                max = Math.max(max, next);
                
                pq.offer(en);
            }
        }
        
        return new int[]{st,ed};
    }
}