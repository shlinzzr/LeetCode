// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array

class Solution {
    public int differenceOfSum(int[] nums) {
        int esum=0;
        int dsum=0;
        
        for(int n : nums){
            
            esum+=n;
            while(n>0){
                dsum+=n%10;
                n/=10;
            }
            
        }
        
        
        return Math.abs(esum-dsum);
            
    }
}