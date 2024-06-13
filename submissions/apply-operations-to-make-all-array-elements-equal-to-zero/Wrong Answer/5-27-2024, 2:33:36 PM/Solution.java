// https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero

class Solution {
    public boolean checkArray(int[] nums, int k) {

        if(k==1) return true;

        int len = nums.length;

        int[] diff = new int[len+1];

        int base = 0 ;
        for(int i=0; i<len; i++){
            
            base += diff[i];
            if(base>nums[i]) return false; // why ??

            int delta = nums[i] - base;

            if(delta > 0 && i+k<len){
                diff[i] += delta;
                diff[i+k] -= delta;
            }
            
            base += delta;
        }

        return true;

        
    }
}