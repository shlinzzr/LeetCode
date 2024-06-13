// https://leetcode.com/problems/sort-the-students-by-their-kth-score

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
//         PriorityQueue<int[] > pq= new PriorityQueue<>(
//             (a, b) -> b[k]-a[k]
//         );
        
//         for(int[] sco : score){
//             pq.offer(sco);
//         }
        
//         int h=score.length;
//         int w=score[0].length;
        
//         int res = new int[h][w];
//         for(int i=0; i<h; i++){
//             res[i] = pq.poll();
            
//             System.arraycopy(pq.poll(), 0, res[i], 0, w);

//         }
        
//         return res;
          
        int h=score.length;
        int w=score[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int []sc = new int[h];
        
        for(int i=0; i<h; i++){
            sc[i] = score[i][k];
            
            map.put(score[i][k], i);
        }
        
        Arrays.sort(sc);
        
        
        int[][] res = new int[h][w];
        for(int i=0; i<h; i++){
            
            int key= sc[i];
            int dst = map.get(key);
            
            int src = h-i-1;
            
            
            res[src]=score[dst];
            
            // swap(score, src, dst);
            
        }
        
        return res;
    }
    
    private void swap(int[][]score, int h1, int h2){
          int w=score[0].length;
        
        for(int j=0; j<w; j++){
            
            int tmp = score[h1][j];
            score[h1][j] = score[h2][j];
            score[h2][j]= tmp;
        }
        
    }
}