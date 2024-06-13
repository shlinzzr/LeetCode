// https://leetcode.com/problems/number-of-islands-ii

class Solution {

    int [] parent;
    public List<Integer> numIslands2(int m, int n, int[][] pos) {

        int cnt = 0;
         parent = new int[m*n];
        int len = pos.length;

        for(int i=0; i<m*n;i++){
            parent[i] = i;
        }

        int[][] mat = new int[m][n];


        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1, 0}};
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<len; i++){
            int[] p = pos[i];
            int y = p[0];
            int x = p[1];
            if(mat[y][x]==1){
                res.add(cnt);
                continue;
            }

            mat[y][x] =1;
            cnt++;


            for(int[] d : dirs){

                int r = d[0]+y;
                int c = d[1]+x;

                if(r<0 || c<0 || r>=m || c>=n || mat[r][c]==0) continue;

                int curr = y*n+x;
                int next = r*n+c;

                if(union(curr,next) ){
                    cnt--;
                }
            }

            res.add(cnt);

        }

        return res;


        
    }


    private int find(int x){
        if(parent[x]!=x) return find(parent[x]);
        return parent[x];
    }

    private boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;

        if(a<b){
            parent[b] = a;
        }else
            parent[a] = b;
        
        return true;
    }
}