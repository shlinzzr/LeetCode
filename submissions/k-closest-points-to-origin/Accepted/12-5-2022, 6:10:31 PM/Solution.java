// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])
        );
        
        for(int[] p: points){
            pq.offer(p);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[][] res = new int[k][];
        for(int i=0; i<k; i++){
            int[] p = pq.poll();
            int[] r = new int[2];
            r[0]=p[0];
            r[1]=p[1];
            res[i] = r;
        }
        
        return res;
        
    }
}