// https://leetcode.com/problems/number-of-islands-ii

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        int h = positions.length;
        int w = positions[0].length;
        
        UnionFind uf = new UnionFind(m*n+1);
        int len = positions.length;
        
        List<Integer> list = new ArrayList<>();
        
        
        int[][] grid = new int[m][n];
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for(int i=0; i<len; i++){
            int[] p = positions[i];
            int y = p[0];
            int x = p[1];
            grid[y][x]=1;
            
            
            for(int[] d: dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                
                if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0)
                    continue;
                
                int a = uf.find(y*n+x);
                int b = uf.find(r*n+c);
                
                if(a!=b){
                    uf.union(a, b);
                }
            }
            
            int cnt =0;        
            for(int ii=0; ii<m; ii++){
                for(int jj=0; jj<n; jj++){

                    int a = ii*n+jj;

                    
                    if(grid[ii][jj]==1 && a==uf.parent[a])
                        cnt++;
                }
            }
            
            list.add(cnt);
            
        }
        
        return list;
        
            
            
        
        
    }
    
    
    
     class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            
            parent = new int[n];
            weight = new int[n];
            
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
            Arrays.fill(weight, 1);
            
            
        }
        
        
        public void union(int a, int b){
            
            a = find(a);
            b = find(b);
            
            if(a==b)
                return ;
            
            if(weight[a]>= weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
            }
            
            
        }
        
        
        public int find(int x){
            if(parent[x] ==x)
                return x;
            
            parent[x] = find(parent[x]);
            return parent[x];
        }
        
        
    }
}