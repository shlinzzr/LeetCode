// https://leetcode.com/problems/campus-bikes

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>( //wi, bi, dis
            (a,b)-> a[2]==b[2]? (a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]) : a[2]-b[2]
        );
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                pq.offer(new int[]{i, j, getDis(workers[i], bikes[j])});
            }
        }
        
        int[] res = new int[n];
        
        Set<Integer> seen_w = new HashSet<>();
        Set<Integer> seen_b = new HashSet<>();
        while(!pq.isEmpty()){
            
            int[] p = pq.poll();
            int wi = p[0];
            int bi = p[1];
            
            
            if(!seen_w.contains(wi) && !seen_b.contains(bi)){
                seen_b.add(bi);
                seen_w.add(wi);
                res[wi] = bi;
                
            }
        }
        
        return res;
        
    }
    
    
    private int getDis(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}