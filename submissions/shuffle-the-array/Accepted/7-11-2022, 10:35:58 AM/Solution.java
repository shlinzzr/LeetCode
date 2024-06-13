// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length/2;
        
        int[] res = new int[nums.length];
        
        for(int i=0; i<len; i++){
            res[2*i] = nums[i];
            res[2*i+1] = nums[i+len];
            
            
        }
        
        
        return res;
        
    }
}