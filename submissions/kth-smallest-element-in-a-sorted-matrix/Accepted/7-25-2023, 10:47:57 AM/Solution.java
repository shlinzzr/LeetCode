// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( //val, row, col
            (a,b) -> a[0]-b[0]
        );
        
        for(int i=0; i<h; i++){
            int[] ele = new int[]{matrix[i][0], i, 0};
            pq.offer(ele);
        }
        
        while(!pq.isEmpty() && k>1){
            
            int[] p = pq.poll();
            int val = p[0];
            int row = p[1];
            int col = p[2];
            
            if(col+1<w){
                int[] ele = new int[]{matrix[row][col+1], row, col+1};
                pq.offer(ele);
            }
            k--;
        }
        
        return pq.peek()[0];
        
    }
}