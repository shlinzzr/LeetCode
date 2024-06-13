// https://leetcode.com/problems/count-sub-islands

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int h = grid1.length;
        int w = grid1[0].length;
        Set<String> seen = new HashSet<>();
        int cnt= 0;

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid2[i][j]==1 && grid1[i][j]==1 && seen.add(i+"_"+j)){

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    boolean valid = true;
                    while(!q.isEmpty()){
                        int[] p = q.poll();

                        for(int[] d : dirs){
                            int r = d[0] + p[0];
                            int c = d[1] + p[1];

                            if(r<0 || c<0 || r>=h || c>=w || seen.add(r+"_"+c)==false || grid2[r][c]==0 )
                                continue;

                            if(grid1[r][c]==0){
                                valid = false;
                            }

                            q.offer(new int[]{r,c});
                           
                        }

                    }
                    if(valid) cnt++;
                }
            }
        }
        return cnt;

    }
}