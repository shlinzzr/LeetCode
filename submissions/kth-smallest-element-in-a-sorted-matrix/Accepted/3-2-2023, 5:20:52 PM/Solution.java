// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2],b[2])
        );
        
        for(int i=0; i<h; i++){
            pq.offer(new int[]{i, 0, matrix[i][0]}); // row ,idx, val
        }
        
        
        while(!pq.isEmpty() && k>1){
            int[] p = pq.poll();
            
            int r = p[0];
            int idx = p[1]; 
            if(idx+1 < matrix[r].length){
                pq.offer(new int[]{r, idx+1, matrix[r][idx+1]});
            }
            k--;
        }
        
        return pq.peek()[2];
        
    }
}