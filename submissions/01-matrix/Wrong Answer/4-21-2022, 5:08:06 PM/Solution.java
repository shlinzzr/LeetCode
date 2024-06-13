// https://leetcode.com/problems/01-matrix

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (y < 0 || y >= h || x < 0 || x >= w || 
                    matrix[y][x] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {y, x});
                matrix[y][x] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}