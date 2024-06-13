// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        int len = nums.length;
        if(len%3!=0)
            return new int[0][];
        
        int h = len/3;
        
        Arrays.sort(nums);
        
        int[][] res = new int[h][3];
        
        for(int i=0; i<len; i+=3){
            
            
            int[] row = new int[3];
            row[0]=nums[i];
            row[1]=nums[i+1];
            row[2]=nums[i+2];
            
            if(row[2]-row[0]>k)
                 return new int[0][];
            
            
            
            res[i/3] = row;
        }
        
        
        return res;
        
        
        
        
    }
}