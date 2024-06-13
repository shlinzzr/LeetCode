// https://leetcode.com/problems/last-day-where-you-can-still-cross

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        UnionFind uf = new UnionFind(row, col);
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0} ,{0,-1}};
        
        //build grid
        int[][] grid = new int[row][col];
        for(int i=0; i<cells.length; i++){
            int[] cell = cells[i];
            int y = cell[0]-1;
            int x = cell[1]-1;
            grid[y][x] = 1;
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){   //T(1e4)
                
                //union
                if(grid[i][j]==0){
                    for(int d[] : dirs){
                    
                        int r = d[0]+i;
                        int c = d[1]+j;
                        
                        if(r<0 || c<0 || r>=row || c>=col || grid[r][c]==1)
                            continue;
                        
                        boolean ures = uf.union(i*col+j, r*col+c);

                        if(ures)
                            return  cells.length;
                        
                        uf.pp();
                    }
                    
                }
            }
        }
        
        
        for(int k=cells.length-1; k>=0; k--){
            
            int[] cell = cells[k];
            
            int y = cell[0]-1;
            int x = cell[1]-1;
            grid[y][x]=0;
            
            for(int[] d : dirs){
                
                int r = y+d[0];
                int c = x+d[1];
                
                if(r<0 || c<0 || r>=row || c>=col || grid[r][c]==1)
                    continue;
                
                boolean ures = uf.union(y*col+x, r*col+c);
                            
                if(ures)
                     return k;
            }
        }
        
        return 0;
        
        
        
        
//         int len = cells.length;
//         int st=0, ed=len-1;
        
//         while(st<ed){
            
//             int mid = st+(ed-st+1)/2;
            
//             boolean bool = isOk(row, col, cells, mid);
            
//             if(bool){
//                 st = mid;
//             }else
//                 ed= mid-1;
//         }
        
//         return isOk(row, col, cells, st) ? st+1 : 0 ;
    }
    
    
    
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        int row; 
        int col;
        
        public UnionFind(int row, int col){
            
            this.row= row;
            this.col = col;
            
            int n = row*col;
            
            this.parent = new int[n];
            this.weight = new int[n];
            
            
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public int find(int x){
            
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public boolean union(int a, int b){
            
            a=find(a);
            b=find(b);
            
            if(a==b)
                return false;
            
            if( (a>=0 && a<col) || (a<row*col && a>= row*col-col)){
                
                parent[b] = a;
                weight[a] += weight[b];
                
            }else{
                parent[a] = b;
                weight[b] += weight[a];
            }
            
            
            if( (a>=0 && a<col) && (b<row*col && b>= row*col-col)
              ||(b>=0 && b<col) && (a<row*col && a>= row*col-col) )
                return true;
            
            return false;
        }
        
        public void pp(){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    System.out.print( parent[i*col + j] + ",");
                }
                System.out.println();
            }
        }
        
        
    }
    
    
    
    
    
    private boolean isOk(int row, int col, int[][]cells, int mid){
        
        int[][] grid = new int[row][col];
        for(int i=0; i<=mid; i++){
            int[] cell = cells[i];
            int y = cell[0]-1;
            int x = cell[1]-1;
            grid[y][x] = 1;
        }
        
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0} ,{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] seen = new boolean[row][col];
        
        for(int j=0; j<col; j++){
            if(grid[0][j]==0){
                q.offer(new int[]{0, j});
                seen[0][j]=true;
            }
        }
        
        while(!q.isEmpty()){
            
            for(int i=q.size(); i>0; i--){
                
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    
                    int r = d[0] + p[0];
                    int c = d[1] + p[1];
                    
                    if(r<0 || c<0 || r>=row || c>=col || seen[r][c] || grid[r][c]==1)
                        continue;
                    
                    if(r==row-1)
                        return true;
                    
                    seen[r][c]=true;
                    q.offer(new int[]{r,c});
                }
            }
        }
        
        return false;
        
        
    }
}