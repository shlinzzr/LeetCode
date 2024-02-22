// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int h=m;
        int w=n;
        
        int[][] arr = new int[h][w];
        
        for(int[] idx: indices){
            int y = idx[0];
            int x = idx[1];
            
            for(int i=0; i<h; i++){
                arr[i][x]++;
            }
            
            for(int i=0; i<w; i++){
                arr[y][i]++;
            }
        }
        
        int res = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                // System.out.println("arr[" + i + "][" +j + "]="+arr[i][j]);
                if(arr[i][j]%2==1)
                    res++;
            }
        }
        
        return res;
        
        
    }
}