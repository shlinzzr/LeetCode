// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> res = new ArrayList<>();
         int h = matrix.length;
         int w = matrix[0].length;

         int top=0, bottom=h-1, left=0, right=w-1;

         while(res.size()<h*w){

            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(res.size()==h*w)break;

            for(int i=top; i<=bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(res.size()==h*w)break;

            for(int i=right; i>=left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(res.size()==h*w)break;

            for(int i=bottom; i>=top; i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(res.size()==h*w)break;
            
         }


         return res;

    }
}