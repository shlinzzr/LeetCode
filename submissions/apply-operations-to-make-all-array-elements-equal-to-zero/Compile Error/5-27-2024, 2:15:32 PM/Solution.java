// https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero

class Solution {
    public boolean checkArray(int[] nums, int k) {

        int len = nums.length;
        
        int curr = 0;

        for(int i=0; i<len; i++){
            if(curr > nums[i]) return false;
            nums[i] -= curr;
            curr += nums[i];

            if(i>=k-1){
                curr -= nums[i-k+1];
            }
        }

        return curr= 0;

        
    }
}