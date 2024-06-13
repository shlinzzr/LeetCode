// https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero

class Solution {
    public boolean checkArray(int[] nums, int k) {

        if(k==1) return true; //k==1特例
        
        //想法 : 從0數組變成nums

        int len = nums.length;

        int[] diff = new int[len+1];

        int base = 0 ;
        for(int i=0; i<len-1; i++){
            
            base += diff[i]; // 之前操作來的
            if(base>nums[i]) return false; //只有加沒有減

            int delta = nums[i] - base;

            if(delta > 0 && i+k<len){
                diff[i] += delta;
                diff[i+k] -= delta;
            }
            
            base += delta;
        }

        return base + diff[len-1] == nums[len-1];

        
    }
}