// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        int h=n;
        int w=n;
        
        int[][] res = new int[n][n];
        int val = 1;
        
        
        int top=0, left=0, down=n-1, right=n-1;
        
        while(top<=down && left<=right){
            
            for(int i=left; i<=right; i++){
                res[top][i]=val++;
            }
            top++;
            
            for(int i=top; i<=down; i++){
                res[i][right]=val++;
            }
            right--;
            
            for(int i=right; i>=left; i--){
                res[down][i] = val++;
            }
            down--;
            
            for(int i=down; i>=top; i--){
                res[i][left] = val++;
            }
            left++;
        }
        
        /*
[[1,8,3]
,[0,9,4]
,[7,6,5]]
        */
        
        return res;
        
    }
}