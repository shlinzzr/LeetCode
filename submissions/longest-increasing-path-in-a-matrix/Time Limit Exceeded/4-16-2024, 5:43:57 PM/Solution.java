// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {

    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

      

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Set<String> seen = new HashSet<>();
                seen.add(i+"_"+j);
                dfs(matrix, i, j, seen, 1);   
                seen.remove(i+"_"+j);
            }
        }

        return max;

     /*
[7,8,9],
[9,7,6],
[7,2,3]]
     */   
    }


    private void dfs(int[][] matrix, int i, int j,  Set<String> seen, int step){

        int h = matrix.length;
        int w = matrix[0].length;
        max = Math.max(max, step);

        for(int[] d: dirs){
            int r = d[0]+i;
            int c = d[1]+j;

            if(r<0 || c<0 || r>=h || c>=w || matrix[r][c]<= matrix[i][j]) continue;
            if(seen.contains(r+"_"+c)) continue;
           
            seen.add(r+"_"+c);
            dfs(matrix, r, c, seen, step+1);
            seen.remove(r+"_"+c);
        }
        


    }

  int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};


    // private int bfs(int[][] matrix, int i, int j){
    //     int h = matrix.length;
    //     int w = matrix[0].length;

    //     S<int[]> q = new LinkedList<>();
    //     q.offer(new int[]{i, j} );

    //     Set<String> seen = new HashSet<>();
    //     seen.add(i + "_"+ j);
      
    //     int step = 0;
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         while(size-->0){

    //             int[] p = q.poll();

    //             for(int[] d: dirs){
    //                 int r = d[0]+p[0];
    //                 int c = d[1]+p[1];

    //                 if(r<0 || c<0 || r>=h || c>=w || matrix[r][c]<= matrix[p[0]][p[1]]) continue;
    //                 if(seen.add(r+"_"+c)==false) continue;
    //                 q.offer(new int[]{r,c});
    //             }

    //         }
    //         step++;
    //     }

    //     return step;
    // }
}