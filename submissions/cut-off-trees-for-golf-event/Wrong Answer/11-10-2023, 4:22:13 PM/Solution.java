// https://leetcode.com/problems/cut-off-trees-for-golf-event

class Solution {

    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int cutOffTree(List<List<Integer>> forest) {

        if(forest.get(0).get(0)==0)
            return -1;

        int m = forest.size();
        int n = forest.get(0).size();

        if(forest.get(0).get(0)==0)
            return -1;

        if(m*n==1)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( // r, c, val
            (a,b) -> a[2]-b[2]
        );
        boolean[][] seen = new boolean[m][n];

        pq.offer(new int[]{0,0,forest.get(0).get(0)});
        q.offer(new int[]{0,0});
        seen[0][0]=true;
        int step=0;

       
        while(!q.isEmpty()){

            int siz = q.size();
            while(siz-->0){
                int[] p = q.poll();

                for(int[] d: dirs){
                    int r= d[0]+p[0];
                    int c = d[1]+p[1];
                    
                    if(r<0 || c<0 || r>=m || c>=n || seen[r][c] || forest.get(r).get(c)==0 ){
                        continue;
                    }
                    seen[r][c]=true;
                    q.offer(new int[]{r,c});
                    pq.offer(new int[]{r,c,forest.get(r).get(c)});
                }
            }
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j)>0 && seen[i][j]==false)
                    return -1;
            }
        }

        int path=0;
        int[] cur= new int[]{0,0};
        while(!pq.isEmpty()){
            int[] nxt = pq.poll();
                
            path += findShortestPath(forest, cur, nxt);

            System.out.println(nxt[0] + ", " + nxt[1] + "=" + nxt[2] + " path="+path);
            cur = nxt;
        }

        return path;

    }


    private int findShortestPath(List<List<Integer>> forest, int[] src, int[] dest){
        if(src[0]==dest[0] && src[1]==dest[1])
            return 0;

        int m = forest.size();
        int n = forest.get(0).size();


        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(src);
        seen[src[0]][src[1]] = true;
        int step = 1;
        while(!q.isEmpty()){
            int siz=q.size();

            while(siz-->0){
                int[] p = q.poll();

                for(int[] d: dirs){

                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                    if(r<0 || c<0 || r>=m || c>=n || seen[r][c] || forest.get(r).get(c)==0 ){
                        continue;
                    }

                    if(r==dest[0] && c==dest[1])
                        return step;

                    seen[r][c]=true;
                    q.offer(new int[]{r,c});
                }
            }
            step++;
        }
        return -1;
    }
}

/*
[[4557,6199,7461,2554,6132,7471,7103,4290]
,[2034,2301,6733,6040,2603,5697,9541,6678]
,[7308,7368,9618,4386,6944,3923,4754,4294]
,[xxxx,3016,7242,5284,6631,1897,1767,7603]
,[2228,xxxx,3625,7713,2956,3264,3371,6124]
,[9195,7804,2787,xxxx,4919,9304,5161,502]]
*/