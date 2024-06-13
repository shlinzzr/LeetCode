// https://leetcode.com/problems/sum-of-squares-of-special-elements

class Solution {
    public int sumOfSquares(int[] nums) {
        int sum =0 ;
        
        int len = nums.length;
        for(int i=0; i<nums.length;i++){
            
            if(len %(i+1)==0)
                sum+= nums[i]*nums[i];
        }
        
        return sum;
    }
}