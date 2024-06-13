// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right){
                return distance(left)-distance(right);
            }
        });
        
        for(int[] p : points){
            
            pq.offer(p);
            if(pq.size()<k)
                pq.poll();
        }
        
        int[][] res = new int[k][2];
        while(k>0){
            res[k-1] = pq.poll();
            k--;
        }
        
        return res;
        
        
    }
    
    
    private int distance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }

}