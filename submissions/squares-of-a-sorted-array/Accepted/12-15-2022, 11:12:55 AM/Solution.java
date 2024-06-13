// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int len = nums.length;
        
        int[] res= new int[len];

        int st=0, ed=len-1;
        
        for(int i=len-1; i>=0; i--){
            if(nums[st]*nums[st]<nums[ed]*nums[ed]){
                res[i] = nums[ed]*nums[ed];
                ed--;
            }else{
                res[i] = nums[st]*nums[st];
                st++;
            }
            
        }
        
        return res;
        
        
    }
}