// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int h = image.length;
        int w = image[0].length;
        
        
        if(image[sr][sc]==color)
            return image;
        
        
        int org = image[sc][sc];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc]=color;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
        
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            
            for(int[] d: dirs){
                
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                
                if(r<0 || c<0 || r>=h || c>=w || image[r][c]!=org)
                    continue;
                
                image[r][c]=color;
                
                q.offer(new int[]{r,c});
            }
        }
        
        return image;
        
    }
}