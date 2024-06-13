// https://leetcode.com/problems/detect-cycles-in-2d-grid

class Solution {
    public boolean containsCycle(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        boolean[][] seen = boolean[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(!seen[i][j]){
                    boolean res = helper(grid, i, j, seen);
                    if(res) return true;
                }
            }
        }
    }

    private boolean helper(char[][] grid, int i, int j, boolean[][] seen){

        int h = grid.length;
        int w = grid[0].length;


        Stack<int[] > q = new LinkedList<>();
        q.offer(new int[]{i, j});
        seen[i][j] = true;

        int step = 0;

        while(!q.isEmpty()){    
            int siz = q.size();
            for(int a=0; a<siz;a++){
                int[] p = q.poll();

                for(int[] d: dirs){
                    int r =  d[0] + p[0];
                    int c = d[1] + p[1];

                    if(r<0 || c<0 || r>=h || c>=w)
                        continue;

                    if(r==i && c==j && step>=3){
                        return true;
                    }

                    if(seen[r][c] && step>=2) return true;

                    seen[r][c] = true;


                }

            }

            step++;

            
        }
    }
}