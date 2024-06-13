// https://leetcode.com/problems/max-number-of-k-sum-pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int st =0, ed=len-1;
        int cnt = 0;
        while(st<ed){
            
            if(nums[st]+nums[ed]==k){
                st++;
                ed--;
                cnt++;
            }else if (nums[st]+nums[ed]>k){
                ed--;
            }else{
                st++;
            }
            
        }
        
        
        return cnt;
    }
}