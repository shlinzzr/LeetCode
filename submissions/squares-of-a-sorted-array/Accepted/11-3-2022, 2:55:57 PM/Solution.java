// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int st=0, ed=nums.length-1;
        
        int[] res =new int[nums.length];
        
        for(int i=nums.length-1;i>=0; i--){
            
            int val=0;
            if(nums[st]*nums[st]>=nums[ed]*nums[ed]){
                val = nums[st]*nums[st];
                st++;
                
            }else{
                val = nums[ed]*nums[ed];
                ed--;
            }
            
            res[i]=val;
        }
        
        return res;
    }
}