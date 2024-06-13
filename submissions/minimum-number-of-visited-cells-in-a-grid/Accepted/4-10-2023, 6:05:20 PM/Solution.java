// https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1)
            return 1;
        
        int[][] visited = new int[m][n];
        queue.add(new int[]{0, 0});
        int dist = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // System.out.println(size);
            while(size > 0) {
                int[] cell = queue.poll();
                // System.out.println("cell: " + cell[0] + ", "  + cell[1] + ", val: " + grid[cell[0]][cell[1]]);
                int val = grid[cell[0]][cell[1]];
                //check right
                for(int col=1; col <= val; col++) {
                    if(col + cell[1] >= n)
                        break;

                    if(cell[0] == m-1 && col + cell[1] == n-1)
                        return dist + 1;

                    if(grid[cell[0]][col + cell[1]] != 0 && visited[cell[0]][col + cell[1]] == 0) {
                        queue.add(new int[]{cell[0], col + cell[1]});
                        visited[cell[0]][col + cell[1]] = 1;
                    }
                }

                //check bottom
                for(int row=1; row <= val; row++) {
                    if(row + cell[0] >= m)
                        break;

                    if(cell[0] + row == m-1 && cell[1] == n-1)
                        return dist + 1;

                    if(grid[row + cell[0]][cell[1]] != 0 && visited[row + cell[0]][cell[1]] == 0) {
                        queue.add(new int[]{row + cell[0], cell[1]});
                        visited[row + cell[0]][cell[1]] = 1;
                    }
                }
                size--;
            }
            dist++;
        }
        
        // System.out.println("");
        // System.out.println("");
        return -1;
    }
}