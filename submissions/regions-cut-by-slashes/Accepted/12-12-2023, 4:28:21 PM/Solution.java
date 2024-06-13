// https://leetcode.com/problems/regions-cut-by-slashes

class Solution {

    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
            count=1;
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int a, int b){
            a = find(a);
            b = find(b);
            if(a==b){
                count++;
                return;
            }

            if(a<b){
                parent[b]=a;
            }else 
                parent[a]=b;
        }
    }


    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        UnionFind uf = new UnionFind((n+1)*(n+1));


        for(int i=0; i<=n; i++){
            for(int j=0;j<=n; j++){
                int idx = i*(n+1)+j;
                // parent[idx]=idx;
                if(i==0 || j==0 || i==n || j==n){
                    uf.parent[idx]=0;
                }
            }
        }

        /*
        when ch=='/':
                      X = i*(n+1) + j+1
        (i,  j),   (i, j+1)
        (i+1,j), (i+1, j+1)
           Y=(i+1)*(n+1) + j
        

        case : when ch=='\\'
            X = i*(n+1)+j
        (i,  j),   (i, j+1)
        (i+1,j), (i+1, j+1)
                      Y=(i+1)*(n+1) + j+1
        */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                
                if (ch == '/') {

                    int x = i * (n + 1) + j + 1;
                    int y = (i + 1) * (n + 1) + j;
                    
                    uf.union(x, y);
                } else if (ch == '\\') {
                    int x = i * (n + 1) + j;
                    int y = (i + 1) * (n + 1) + j + 1;
                    
                    uf.union(x, y);
                }
            }
        }

        return uf.count;

        
    }
}