// https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location

class Solution {

    int[][] dirs = new int[][]{{-1,0}, {0, -1}, {1,0},{0,1}}; // right, left, down, up


    public int minPushBox(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        // 1. can b go t?
        // 2a. s can't  go b => retrun false
        // 2b  s can go b && (s can't go t) => return true;
        // 2c  s can go b with 2 more way

        // x x x x x x 
        // x t x x x x  
        // x   b x x x  
        // x x   x x x 
        // x x s x x x 


        int[] box = null;
        int[] target = null;
        int[] man = null;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]=='B'){
                    box = new int[]{i, j};
                }
                if(grid[i][j]=='T'){
                    target = new int[]{i, j};
                }
                if(grid[i][j]=='S'){
                    man = new int[]{i, j};
                }

                if(box!=null && target!=null && man!=null)
                    break;
            }
        }


        for(int[] d : dirs){  // {0,1}, {0, -1}, {1,0},{-1, 0}

            int r = box[0] + d[0];
            int c = box[1] + d[1];
            int pr = box[0] - d[0];
            int pc = box[1] - d[1];


           
            if(r<0 || c<0 || r>=h || c>=h || grid[r][c]=='#')
                continue;
                
            if( pr<0 || pc<0 || pr>=h || pc>=w || grid[pr][pc]=='#')
                continue;


 System.out.println(d[0]+","+d[1] + " pr"+pr + " pc="+pc);
            //check man can go {pr,pc}
            int manToBoxPrev = canGo(grid, man, new int[]{pr,pc}, false);

            int boxToTarget = canGo(grid, new int[]{r,c}, target, true);

            System.out.println(d[0]+","+d[1] + " " +manToBoxPrev + " " + boxToTarget);

            if(manToBoxPrev>0 && boxToTarget>0)
                return boxToTarget+1;
        }

        return -1;

       /*
       [["#","#","#","#","#","#"]
       ,["#","T","#","#","#","#"]
       ,["#",".",".","B",".","#"]
       ,["#",".","#","#",".","#"]
       ,["#",".",".",".","S","#"]
       ,["#","#","#","#","#","#"]]

       */


    }

    private int canGo(char[][]grid, int[] src, int[] tar, boolean checkPrev){


        System.out.println( "cango chkprev"+checkPrev);
        int h = grid.length;
        int w = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(src);

        int step = 1 ;
        boolean[][] seen = new boolean[h][w];
        //check box can go to target
        while(!q.isEmpty()){
           
            int siz = q.size();

            for(int i=0; i<siz; i++){
                int[] p = q.poll();

                System.out.println(step + " " +p[0] + " "+p[1]);
                for(int[] d: dirs){

                    int r = p[0]+d[0];
                    int c = p[1]+d[1];

                    int pr = p[0]-d[0];
                    int pc = p[1]-d[1];

                    
                    if(checkPrev && ( pr<0 || pc<0 || pr>=h || pc>=w || grid[pr][pc]=='#'))
                        continue;

                    if(r==tar[0] && c==tar[1])
                        return step;

                    if(r<0 || c<0 || r>=h || c>=h || grid[r][c]=='#' || seen[r][c] || grid[r][c]=='B')
                        continue;

                    seen[r][c] = true;
                    q.offer(new int[]{r,c});
                }
            }
            step++;
        }

        return -1;
    }
}