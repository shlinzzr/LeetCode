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
         
            System.out.println( "\n start while ");
            
            int[] curr = queue.poll();
            System.out.println( Arrays.toString(curr));
            
            for(int [] ii : visited){
                System.out.println( "visited="+ Arrays.toString(ii));
            }
                
            
            
            int y = curr[0];
            int x = curr[1];
            if(!isInList(visited, curr)){
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
            
            for(int[] adj : adjs){
                
                System.out.println( "adj="+Arrays.toString(adj));
            
                if(!isInList(visited, adj))
                    if( image[adj[0]][adj[1]] == oldColor)
                        queue.add(adj);
            }
        }
        return image;
        
    }
    public static boolean isInList(
    final List<int[]> list, final int[] candidate){

    for(final int[] item : list){
        if(Arrays.equals(item, candidate)){
            return true;
        }
    }
    return false;
}
    
}