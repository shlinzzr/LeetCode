// https://leetcode.com/problems/swim-in-rising-water

class Solution {
    public int swimInWater(int[][] grid) {
        int h= grid.length;
        int w= grid[0].length;

        int st=0,ed=2499;
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(ok(grid, mid)){
                ed=mid;
            }else{
                st=mid+1;
            }

        }

        return st;

    }

    private boolean ok(int[][] grid, int mid){
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        return  dfs(grid, mid, 0, 0, seen);
    }

    private boolean dfs(int[][] grid, int mid, int x, int y, boolean[][] seen ){

        int n = grid.length;

        if(seen[x][y]) return false;

        seen[x][y]=true;

        if(grid[x][y]>mid)
            return false;

        if(x==n-1 && y==n-1)
            return true;
        
        boolean rt = false;
        if(x+1<n && grid[x+1][y]<=mid )  rt = rt || dfs(grid, mid, x+1, y, seen);
        if(x-1>=0 && grid[x-1][y]<=mid)  rt = rt || dfs(grid, mid, x-1, y, seen);
        if(y+1<n && grid[x][y+1]<=mid)  rt = rt || dfs(grid, mid, x, y+1, seen);
        if(y-1>=0 && grid[x][y-1]<=mid)  rt = rt || dfs(grid, mid, x, y-1, seen);

        return rt;
        
    }
}