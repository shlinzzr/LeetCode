// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> res= new HashSet<>();

        int h = heights.length;
        int w = heights[0].length;


        // res.add(Arrays.asList(0,w-1));
        // res.add(Arrays.asList(h-1,0));

        boolean[][] pac = new boolean[h][w];
        boolean[][] atl = new boolean[h][w];

        Queue<int[]> pq= new LinkedList<>();
        boolean[][] pseen= new boolean[h][w];

        Queue<int[]> aq= new LinkedList<>();
        boolean[][] aseen= new boolean[h][w];

        for(int i =0; i<h; i++){
            pseen[i][0] = true;
            pq.offer(new int[]{i, 0});
            pac[i][0]=true;

            atl[i][w-1]=true;
            aseen[i][w-1] = true;
            aq.offer(new int[]{i, w-1});
        }

        for(int j=0; j<w; j++){
            pseen[0][j] = true;
            pq.offer(new int[]{0,j});
            pac[0][j]=true;

            // if(atl[0][j])
            //     res.add(Arrays.asList(0,j));

            atl[h-1][j]=true;
            aseen[h-1][j] = true;
            aq.offer(new int[]{h-1,j});
            // if(pac[h-1][j])
            //     res.add(Arrays.asList(h-1,j));
        }

       

        int[][] dirs = new int[][]{{1,0},{-1,0}, {0,1}, {0,-1}};
        while(!pq.isEmpty()){
            int[] p = pq.poll();

            if(atl[p[0]][p[1]] && pac[p[0]][p[1]])
                res.add(Arrays.asList(p[0],p[1]));


            for(int[] d : dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                if(r<0 || c<0 || r>=h || c>=w || pseen[r][c] || heights[r][c]<heights[p[0]][p[1]]) 
                    continue;

                pseen[r][c] = true;
                pac[r][c]=true;
                pq.offer(new int[]{r, c});
            }
        }

        while(!aq.isEmpty()){
            int[] p = aq.poll();

            for(int[] d : dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                if(r<0 || c<0 || r>=h || c>=w || aseen[r][c] || heights[r][c]<heights[p[0]][p[1]]) 
                    continue;

                aseen[r][c] = true;
                atl[r][c] =true;
                if(pac[r][c]==true){
                    res.add(Arrays.asList(r,c));
                }

                aq.offer(new int[]{r, c});
            }
        } 

        return new ArrayList<>(res);
        

    }
}