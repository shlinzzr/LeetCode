// https://leetcode.com/problems/rank-transform-of-a-matrix

class Solution {

    int[] parent;
    Map<Integer, List<int[]>> map =new TreeMap<>();
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[m][n];


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int[] xy = {i, j};
                int val = matrix[i][j];
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val, xy);

            }
        }


    }
}