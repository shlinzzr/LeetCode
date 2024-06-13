// https://leetcode.com/problems/cut-off-trees-for-golf-event

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {

        if(forest.get(0).get(0)==0)
            return -1;

        int m = forest.size();
        int n = forest.get(0).size();

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

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
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

            path += Math.abs(nxt[0]-cur[0])+Math.abs(nxt[1]-cur[1]);
            cur = nxt;
        }

        return path;

    }
}