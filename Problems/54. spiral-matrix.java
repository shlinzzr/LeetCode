// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int top = 0, left =0, right= w-1, bottom = h-1;
        
        
        List<Integer> list = new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int j=left; j<=right; j++){
                list.add(matrix[top][j]);
            }
            top++;
            if(top>bottom) break;
            
            for(int i=top; i<=bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            
            if(left>right) break;
            
            for(int j=right; j>=left; j--){
                list.add(matrix[bottom][j]);
            }
            bottom--;
            if(top>bottom) break;
            
            for(int i=bottom; i>=top; i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }
        
        return list;
        
        
        
        
    }
}