// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int st=0, len=nums.length, ed=len-1;
        
        int[] res = new int[len];
        int idx = len-1;
        while(idx>0){
            if(Math.abs(nums[st]) > Math.abs(nums[ed])){
                res[idx]=nums[st]*nums[st];
                st++;
            }else{
                res[idx]=nums[ed]*nums[ed];
                ed--;
            }
            idx--;
        }
        
        return res;
    }
}