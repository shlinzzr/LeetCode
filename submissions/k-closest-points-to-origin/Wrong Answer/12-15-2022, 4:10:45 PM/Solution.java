// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
           (a,b) -> b[0]*b[0]+b[1]*b[1]-a[0]*a[0]+a[1]*a[1] 
        );
        
        for(int[] p : points){
            pq.offer(p);
            
            if(pq.size()>k)
                pq.poll();
        }
        
        int[][] res = new int[k][2];
        for(int i=0; i<pq.size(); i++){
            int[] p = pq.poll();
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        
        return res;
        
    }
}