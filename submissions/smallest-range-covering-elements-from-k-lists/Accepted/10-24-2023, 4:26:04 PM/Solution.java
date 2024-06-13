// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( // int[rowIdx, colIdx, value]
            (a,b)->Integer.compare(a[2], b[2])
        );
        
        int size = nums.size();
        
        int max = Integer.MIN_VALUE;
    
        for(int i=0; i<size; i++){
            int val = nums.get(i).get(0);            
            int[] en = new int[]{i, 0, val};
            pq.offer(en);
            
            max = Math.max(max, val);
        }
        
        
        int left=-100000, right=max, range = 200000;
        while(pq.size()==size){
            
            int[] p = pq.poll();
            int row = p[0];
            int col = p[1];
            int val = p[2];
            
            if(max-val<range){
                left = val;
                right = max;
                range = right-left;
            }
            
            
            if(col+1<nums.get(row).size()){
                
                int newVal = nums.get(row).get(col+1);
                max = Math.max(max, newVal);
                
                int[] en = new int[]{row, col+1, newVal};
                pq.offer(en);
            }
            
            
            
        }
        
        return new int[]{left, right};
        
        
    }
}