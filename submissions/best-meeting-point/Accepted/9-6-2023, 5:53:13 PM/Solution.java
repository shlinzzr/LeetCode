// https://leetcode.com/problems/best-meeting-point

class Solution {
    public int minTotalDistance(int[][] grid) {
        
        //https://www.bilibili.com/video/BV1Sv411M7uk/?vd_source=c9ea2869a251a096987b9bd5effa8d78
        
        int h = grid.length;
        int w = grid[0].length;
        
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1){
                    yList.add(i);
                    xList.add(j);   
                }
            }
        }
        
        Collections.sort(xList);
        Collections.sort(yList);
        
        int y = yList.get(yList.size()/2);
        int x = xList.get(xList.size()/2);
        
        int res = 0;
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1){                
                    res += Math.abs(i-y) + Math.abs(j-x);
                }
            }
        }
        return res;
        
    }
}
    
     
//     public int getMeetingPoint(int[][] grid ) {
//         if (grid == null || grid[0].length == 0) return 0;
          
//         int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
//         int h = grid.length;
//         int w = grid[0].length;
        
//         int[][] distance = new int[h][w];
//         int[][] reach = new int[h][w];
//         int buildingNum = 0;
        
        
//         for(int i=0; i<h;i++){
//             for(int j=0; j<w; j++){
//                 if (grid[i][j] == 1) {
//                     buildingNum++;
//                      reach[i][j]++;
//                 }
//             }
//         }
        
//         int min = Integer.MAX_VALUE;
//         for(int i=0; i<h;i++){
//             for(int j=0; j<w; j++){
//                 if (grid[i][j] == 1) {
//                     Queue<int[]> q = new LinkedList<int[]>();
//                     q.offer(new int[] {i,j});

//                     boolean[][] seen = new boolean[h][w]; 
//                     int step = 1;
                    
//                     while (!q.isEmpty()) {
//                         int siz = q.size();
//                         while(siz-->0){
//                             int[] p = q.poll();
                            
//                             for(int[] d : dirs){
//                                 int r = p[0] + d[0];
//                                 int c = p[1] + d[1];
                                
//                                 if(r<0 || c<0 || r>=h || c>=w || seen[r][c] )
//                                     continue;
                                
//                                 distance[r][c] += step;
//                                 reach[r][c]++;
                                
//                                 if(reach[r][c]==buildingNum){
//                                     System.out.println(r+" " +c);
//                                     for(int a=0; a<h;a++){
//                                         for(int b=0; b<w; b++){
//                                             System.out.print(distance[a][b] + ", ");
//                                         }
//                                         System.out.println();
//                                     }
                                    
//                                     min = Math.min(min, distance[r][c]);
                                    
//                                 }
                                

//                                 seen[r][c] =true;
//                                 q.offer(new int[]{r,c});
//                             }
//                         }
//                         step++;
//                     }
//                 }
//             }
//         }
        
//         return min;
        
        
        
//     }
// }