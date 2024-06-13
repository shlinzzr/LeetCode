// https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score

class Solution {
    public int maxScore(int[] nums) {
        // Arrays.sort(nums, Collections.reverseOrder());
        Arrays.sort(nums);
        
        int i = nums.length-1;
        int max=nums[i];
        for(i--; i>=0; i--){
            int n = nums[i];
            if(n>0){
                max+=n;
            }
        }
        
        return max;
    }
}