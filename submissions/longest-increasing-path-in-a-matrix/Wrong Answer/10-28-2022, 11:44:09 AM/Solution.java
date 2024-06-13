// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(
            (e1,e2) -> e1.val-e2.val
        );
            
        int res = 0;
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int[][] dirs = new int[][]{{1,0},{0,1}, {-1,0}, {0,-1}};
        int[][] inDegree = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Element e = new Element(i, j, matrix[i][j]);
                
                for(int[] d : dirs){
                    int r = e.i+d[0];
                    int c = e.j+d[1];
                    
                    if(r>=0 && r<h && c>=0 && c<w && matrix[r][c]<matrix[e.i][e.j])
                        inDegree[e.i][e.j]++;
                }
                
                
                pq.offer(e);
            }
        }
        
       
        
        while(pq.size()>0){
            
            boolean[][] seen  = new boolean[h][w];
            
            Element head = pq.poll();
            while(seen[head.i][head.j]==true && pq.size()>0)
                head = pq.poll();
            if(pq.size()==0 && seen[head.i][head.j]==true)
                break;
            
            
            Queue<Element> q = new LinkedList<>();
            q.offer(head);
            seen[head.i][head.j]=true;
            
            int cnt=0;
            while(!q.isEmpty()){
                
                cnt++;
                int siz= q.size();
                for(int s=0;s<siz; s++){
                    Element e = q.poll();
                    
                    for(int[] d : dirs){
                        int r = e.i+d[0];
                        int c = e.j+d[1];

                        if(r>=0 && r<h && c>=0 && c<w && matrix[r][c]>e.val && inDegree[r][c]>=0){
                            q.offer(new Element(r,c,matrix[r][c]));
                            inDegree[r][c]--;
                        }
                    } 
                }
            }
            
            res = Math.max(res, cnt);
        }
        
        return res;
        
            
            
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