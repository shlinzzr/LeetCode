// https://leetcode.com/problems/detect-cycles-in-2d-grid

class Solution {
    public boolean containsCycle(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        int[][] seen = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(seen[i][j]!=0){
                    boolean res = helper(grid, i, j, seen);
                    if(res) return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};

    private boolean helper(char[][] grid, int i, int j, int[][] seen){

        int h = grid.length;
        int w = grid[0].length;


        Queue<int[] > q = new LinkedList<>();
        q.offer(new int[]{i, j, i, j}); // curr ,prev

        int step = 0;

        while(!q.isEmpty()){    
            int siz = q.size();
            for(int a=0; a<siz;a++){
                int[] p = q.poll();
                int pr = p[2];
                int pc = p[3];

                for(int[] d: dirs){
                    int r = d[0] + p[0];
                    int c = d[1] + p[1];

                    if(r<0 || c<0 || r>=h || c>=w)
                        continue;
                    
                    if(seen[pr][pc]-seen[r][c]>=3) return true;

                    if(seen[r][c]!=0) continue;
                    seen[r][c] = step;
                }

            }

            step++;

            
        }

        return false;
    }

}