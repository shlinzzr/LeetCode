// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[2], b[2])
        );
        
        int row= nums.size();
        
        int max = Integer.MIN_VALUE;
    
        for(int i=0; i<row; i++){
            int val = nums.get(i).get(0);            
            int[] en = new int[]{i, 0, val};
            pq.offer(en);
            
            max = Math.max(max, val);
        }
        
        
        int st=-100000, ed=max, range = 200000;
        while(pq.size()==row){
            
            int[] p = pq.poll();
            
            if(max-p[2]<range){
                st = p[2];
                ed = max;
                range = ed-st;
            }
            
            
            if(p[1]+1<nums.get(p[0]).size()){
                
                int newVal = nums.get(p[0]).get(p[1]+1);
                max = Math.max(max, newVal);
                
                int[] en = new int[]{p[0], p[1]+1, newVal};
                pq.offer(en);
            }
            
            
            
        }
        
        return new int[]{st, ed};
        
        
    }
}