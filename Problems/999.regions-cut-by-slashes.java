// https://leetcode.com/problems/regions-cut-by-slashes

class Solution {

    /*
    把一個n*n網格expand成(n+1)*(n+1)個node
    初始化把n*n的四個邊parent都設為0
    檢查端點有沒有相連
    各端點都沒有連起來的時候 總count數==1
    */

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
        // 把一個n*n網格expand成(n+1)*(n+1)個node
        UnionFind uf = new UnionFind((n+1)*(n+1));

        for(int i=0; i<=n; i++){
            for(int j=0;j<=n; j++){
                int idx = i*(n+1)+j;  // convert to 1d-array idx
                if(i==0 || j==0 || i==n || j==n){ // initialize the edge's parent to 0
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