// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int st=0, ed= nums.length-1;
        
        
        Arrays.sort(nums);
        
        while(st<ed){
            if(nums[st]+nums[ed]==target)
                return new int[]{st,ed};
            else  if(nums[st]+nums[ed]>target)
                ed--;
            else
                st++;
        }
        
        return new int[2];
    }
}