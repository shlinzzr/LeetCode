// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    
    int res = 0;
    int[][] dirs = new int[][]{{1,0},{0,1}, {-1,0}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(
            (e1,e2) -> e1.val-e2.val
        );
            
        
        
        int h = matrix.length;
        int w = matrix[0].length;
        
       
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Element e = new Element(i, j, matrix[i][j]);
                pq.offer(e);
            }
        }
        
        
        
        
        
        while(pq.size()>0){
            
            boolean[][] seen  = new boolean[h][w];
            Element e = pq.poll();
            dfs(e.i, e.j, seen, matrix, 1);
            
        }
            
//             
//             while(seen[head.i][head.j]==true && pq.size()>0)
//                 head = pq.poll();
//             if(pq.size()==0 && seen[head.i][head.j]==true)
//                 break;
            
            
//             Queue<Element> q = new LinkedList<>();
//             q.offer(head);
//             seen[head.i][head.j]=true;
            
//             int cnt=0;
//             while(!q.isEmpty()){
                
//                 cnt++;
//                 int siz= q.size();
//                 for(int s=0;s<siz; s++){
//                     Element e = q.poll();
                    
//                     for(int[] d : dirs){
//                         int r = e.i+d[0];
//                         int c = e.j+d[1];

//                         if(r>=0 && r<h && c>=0 && c<w && matrix[r][c]>e.val && seen[r][c]==false){
//                             q.offer(new Element(r,c,matrix[r][c]));
//                             seen[r][c]=true;
//                         }
//                     } 
//                 }
//             }
            
//             res = Math.max(res, cnt);
//         }
        
        return res;
        
            
            
    }
    
    
    private void dfs(int i, int j, boolean[][] seen, int[][] matrix, int cnt){
        int h = matrix.length;
        int w = matrix[0].length;
        
        res = Math.max(cnt, res);
        
        for(int[] d : dirs){
            int r = i+d[0];
            int c = j+d[1];

            if(r>=0 && r<h && c>=0 && c<w && matrix[r][c]>matrix[i][j] && seen[r][c]==false){
                seen[r][c]=true;
                dfs(r, c, seen, matrix, cnt+1);
                seen[r][c]=false;
            }
        } 
        
    }
    
    
    
    class Element{
        int i;
        int j;
        int val;
        
        public Element(int i, int j, int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
}