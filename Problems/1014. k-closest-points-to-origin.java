// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    
    class Point{
        int[] p;
        int dis;
        
        public Point(int[] p){
            this.p = p;
            dis = getDis(new int[]{0,0}, p);
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (a,b)->b.dis-a.dis
        );
        
        for(int[] p : points){
            Point point = new Point(p);
            // System.out.println(point.dis);
            pq.offer(point);
            
            if(pq.size()>k){
                pq.poll();            
            }
        }
        
        int idx=0;
        int[][] res = new int[pq.size()][];
        while(!pq.isEmpty()){
            res[idx++] = pq.poll().p;
        }
        
        return res;
        
        
    }
    
    private int getDis(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}