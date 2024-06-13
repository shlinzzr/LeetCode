// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        
        int idx =0;
        
        int[] res = new int[2*n];
        for(int i=0; i<n;i++){
            res[idx++]=nums[i];
            res[idx++]=nums[n+i];
        }
        
        return res;
        
        
    }
}