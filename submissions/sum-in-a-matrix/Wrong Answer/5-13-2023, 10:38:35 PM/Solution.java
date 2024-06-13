// https://leetcode.com/problems/sum-in-a-matrix

class Solution {
    public int matrixSum(int[][] nums) {
        int len = nums.length;
        
        int res = 0;
        

        int w = nums[0].length;
        
         for(int j=0; j<w; j++){
             int max = 0;
            for(int i=0; i<len ; i++){
            
            
           
                
                max = Math.max(max, nums[i][j]);
                
            
            }
            // System.out.println(max);
            res+=max;
        }
        
        return res;
        
    }
}