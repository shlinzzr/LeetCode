// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    
    public int assignBikes(int[][] workers, int[][] bikes) {
    
        int wLen = workers.length;
        int bLen = bikes.length;
        
        Set<Integer> set_b = new HashSet<>();
        for(int j=0; j<bLen; j++){
            set_b.add(j);
        }
         
        dfs(workers, bikes, set_b, 0, 0);
    
        return min;
    }
    int min = Integer.MAX_VALUE;
    
    
    private void dfs(int[][] workers, int[][] bikes, Set<Integer> set_b, int cur, int idx ){
        
        if(idx==workers.length){
            min = Math.min(min ,cur);
            return;
        }
            
        for(int j : set_b){
            
            
            Set<Integer> nextSet = new HashSet(set_b);
            nextSet.remove(j);
            dfs(workers, bikes, nextSet, cur+getDis(workers[idx], bikes[j]), idx+1);

        }
        
    }
    
    
//     public int assignBikes(int[][] workers, int[][] bikes) {
        
//         int wLen = workers.length;
//         int bLen = bikes.length;
        
//         Set<Integer> set_w = new HashSet<>();
//         Set<Integer> set_b = new HashSet<>();
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>( // wi, bi, dis
//             (a,b)-> a[2]-b[2]
//         );
        
        
//         for(int i=0; i<wLen; i++){
//             for(int j=0; j<bLen; j++){
//                 pq.offer(new int[]{i, j, getDis(workers[i], bikes[j])});
//             }
//         }
//         int sum = 0;
//         int cnt = wLen;
//         while(wLen>0){
            
//             int[] p = pq.poll();
            
//             int wi = p[0];
//             int bi = p[1];
//             int dis = p[2];
//             if(!set_w.contains(wi) && !set_b.contains(bi)){
//                 set_w.add(wi);
//                 set_b.add(bi);
//                 sum += dis;
//                 wLen--;
//             }
//         }
        
//         return sum;
        
//     }
    
    private int getDis(int[] a, int []b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}