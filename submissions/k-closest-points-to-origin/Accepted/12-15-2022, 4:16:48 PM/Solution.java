// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
           (a,b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]) 
        );
        
        for(int[] p : points){
            pq.offer(p);
             // System.out.println(p[0]+"," + p[1]);
            if(pq.size()>k){
                System.out.println();
                
                int[] tmp = pq.poll();
                
//                 System.out.println(tmp[0]+"," + tmp[1]);
            }
                
        }
        
        int[][] res = new int[k][2];
        int siz = pq.size();
        for(int i=0; i<siz; i++){
            int[] p = pq.poll();
            
            // System.out.println(p[0]+"," + p[1]);
            
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        
        return res;
        
    }
}