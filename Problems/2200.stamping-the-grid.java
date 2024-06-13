// https://leetcode.com/problems/stamping-the-grid

class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int h = grid.length;
        int w = grid[0].length;
        Presum p1 = new Presum(grid);

        int[][] stamps = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                int a = i+stampHeight-1;
                int b = j+stampWidth-1;
                if(a>=h || b>=w) continue;

                if(p1.getArea(i,j,a,b)==0){
                    stamps[a][b]=1;
                    // System.out.println( i + " " + j);
                }
            }
        }

        Presum p2 = new Presum(stamps);
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1) continue;
                
                int a = Math.min(h-1, i+stampHeight-1);
                int b = Math.min(w-1, j+stampWidth-1);
                int area = p2.getArea(i, j, a, b);
                
                //    System.out.println(i + " " + j+ " " + a + " " +b + " " + area);
                if(area==0) {

                 
                    return false;
                }
            }
        }   

        return true;



// // 
// [[1,0,0,0]
// ,[1,0,0,0]
// ,[1,0,0,0]
// ,[1,0,0,0]
// ,[1,0,0,0]] 
//        //
// 0 1 3 3 2
// 0 2 3 3 0


        
    }

    class Presum{
        int h;
        int w;
        int[][] presum;
        public Presum(int[][] grid){
            this.h = grid.length;
            this.w = grid[0].length;
            this.presum = new int[h+1][w+1];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    presum[i+1][j+1] = grid[i][j] + presum[i][j+1]+ presum[i+1][j] - presum[i][j];
                }
            }

        }

        public int getArea(int i, int j, int a, int b){ // upLeft:[i, j], bottomRight:[a,b]
            return presum[a+1][b+1] - presum[a+1][j] - presum[i][b+1] + presum[i][j];
        }

    }
}