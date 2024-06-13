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
        
        
        
        
        int[][] cached = new int [h][w];
        while(pq.size()>0){
            
            Element e = pq.poll();
             int len  = dfs(matrix, e.i, e.j, cached);
            res = Math.max(len, res);
        }
        return res;
        
            
            
    }
    
    
    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        
         int h = matrix.length;
        int w = matrix[0].length;
        
        if(cache[i][j] != 0) 
            return cache[i][j];
        
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= h || y < 0 || y >= w || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
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