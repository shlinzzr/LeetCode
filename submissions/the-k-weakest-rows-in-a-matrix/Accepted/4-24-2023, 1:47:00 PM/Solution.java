// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int h = mat.length;
        int w = mat[0].length;
        
        int[] res = new int[k];
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> (a[1]==b[1])? a[0]-b[0] : a[1]-b[1]
        );
        
        for(int i=0; i<h; i++){
            
            int total=0;
            
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0)
                    break;
                
                total+=mat[i][j];
            }
            pq.offer(new int[]{i, total});
        }
        
                
        for(int i=0; i<k;i++){
            res[i] = pq.poll()[0];
        }
            
        return res;
        
    }
}