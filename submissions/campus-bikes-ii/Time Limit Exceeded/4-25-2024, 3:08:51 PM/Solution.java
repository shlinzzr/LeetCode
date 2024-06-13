// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    
    public int assignBikes(int[][] workers, int[][] bikes) {
    
        int wLen = workers.length;
        int bLen = bikes.length;
        
        Set<Integer> set_w = new HashSet<>();
        Set<Integer> set_b = new HashSet<>();
         
        dfs(workers, bikes, set_w, set_b, 0, 0);
    
        return min;
    }
    int min = Integer.MAX_VALUE;
    
    
    private void dfs(int[][] workers, int[][] bikes, Set<Integer> set_w, Set<Integer> set_b, int cur, int st ){
        
        if(set_w.size()==workers.length){
            min = Math.min(min ,cur);
            return;
        }
        
        for(int i=st; i<workers.length; i++){
            if(set_w.contains(i)) continue;
            
            set_w.add(i);
            for(int j=0; j<bikes.length; j++){
                if(set_b.contains(j)) continue;
                
                set_b.add(j);
                dfs(workers, bikes, set_w, set_b, cur+getDis(workers[i], bikes[j]), st+1);
                set_b.remove(j);
                
            }
            set_w.remove(i);
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