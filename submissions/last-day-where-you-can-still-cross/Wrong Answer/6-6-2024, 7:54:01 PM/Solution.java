// https://leetcode.com/problems/last-day-where-you-can-still-cross

class Solution {
    // _ _ _ _
    // _ _ _ _

    int[] parent;
    public int latestDayToCross(int row, int col, int[][] cells) {
        col+=2;
        parent = new int[row*col];
        for(int i=0; i<row*col; i++){
            parent[i] = i;
            if(i%col==0 || i%col==col-1){
                parent[i] = i%col;
            }
        }

        // always check parent[0] and parent[col-1];

        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};

        for(int i=0; i<cells.length; i++){
            int [] cell = cells[i];
            int x = cell[1];
            int y = cell[0]-1;
            int curr = y*col+x;

            for(int[] d: dirs){
                int r = d[0] + y;
                int c = d[1] + x;
                if(r<0 || c<0 || r>=row || c>=col) continue;

                int next = r*col+c;

                union(next, curr);

                if(find(0) == find(col-1)) return i;
            }
        }

        return -1;
        
    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }


    private boolean union(int i, int j){
        int a = find(i);
        int b = find(j);
        if(a==b) return false;

        if(a<b) parent[b]=a;
        else parent[a]=b;

        return true;


    }

}