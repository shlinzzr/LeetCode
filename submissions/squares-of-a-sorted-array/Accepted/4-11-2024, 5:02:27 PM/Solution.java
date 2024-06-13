// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int len = nums.length;
        int[] res = new int[len];
        
        int st=0, ed=len-1, idx=len-1;
        
        while(st<=ed){
            if(nums[st]*nums[st]>=nums[ed]*nums[ed]){
                res[idx] = nums[st]*nums[st];
                idx--;
                st++;
                
            }else{
                res[idx] = nums[ed]*nums[ed];
                idx--;
                ed--;
            }
        }
        
        return res;
        
    }
}