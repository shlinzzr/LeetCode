// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {

        int lo = 0;
        int hi = nums.length-1;
        int[] res = new int[nums.length];
        int r=nums.length-1;
        while(lo<=hi){
            
            if(Math.abs(nums[lo])>Math.abs(nums[hi])){
                res[r]= nums[lo] * nums[lo];
                lo++;
            }else{
                 res[r]= nums[hi] * nums[hi];
                hi--;
            }
            r--;
        }
        
        
        
    
            
    return res;
    }
}