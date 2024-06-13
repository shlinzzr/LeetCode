// https://leetcode.com/problems/shortest-path-to-get-food

class Solution {
    public int getFood(char[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char ch = grid[i][j];
                if(ch=='*'){
                    q.offer(new int[]{i, j});
                    break;
                } 
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0}, {0,-1}};
        int step = 0;
        while(!q.isEmpty()){
            int size= q.size();
            while(size-->0){
                int[] p = q.poll();

                for(int[] d : dirs){
                    int r = d[0]+p[0];
                    int c = d[1] + p[1];
                    if(r<0 || c<0 || r>=h || c>=w || grid[r][c]=='X' || grid[r][c]=='*') continue;

                    if(grid[r][c]=='#') return step+1;
                    grid[r][c] = 'X';
                    q.offer(new int[]{r,c});
                }
            }
            step++;
        }

        return -1;
    }
}