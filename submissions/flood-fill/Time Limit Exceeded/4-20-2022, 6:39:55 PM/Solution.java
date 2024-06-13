// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        // BFS
        int oldColor = -1;
        
        int height = image.length;
        int width = image[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        
        List<int[]> visited = new ArrayList<>(); 
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            if(!visited.contains(curr)){
                oldColor = image[y][x];
                image[y][x] = newColor;
                visited.add(curr);
            }
                
            
            List<int[]> adjs = new ArrayList<>();
            
            
            if(y-1>=0)
                adjs.add (new int[] {y-1, x}); // up
            
            if(y+1<height)
                adjs.add (new int[] {y+1, x}); // down
            
            if(x-1>=0)
                adjs.add (new int[] {y, x-1}); // left
            
            if(x+1<width)
                adjs.add (new int[] {y, x+1}); // right
            
            for(int[] adj : adjs)
                if(!visited.contains(adj))
                    if( image[adj[0]][adj[1]] == oldColor)
                        queue.add(adj);
        }
        return image;
        
    }
}