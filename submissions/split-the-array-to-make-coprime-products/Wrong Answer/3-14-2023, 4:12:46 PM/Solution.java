// https://leetcode.com/problems/split-the-array-to-make-coprime-products

class Solution {
    public int findValidSplit(int[] nums) {
        
  
        int possible =0;
        int n = nums.length;
        for(int i=0;i<=possible;i++){
            int ele = nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]%ele==0) possible = Math.max(possible,j);
                if(ele%nums[j]==0) possible = Math.max(possible,j);
            }
        }
        return possible<=(n-2)?possible:-1;
    }
}