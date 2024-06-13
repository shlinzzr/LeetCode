// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {

        int len = nums.length;
        int cnt = 0;
        // non-desc
        // equal or asc
        if(len==1) return true;

        boolean seen = false;

        int min = nums[1];
        for(int i=0; i<len-1; i++){

            if(nums[i]<=nums[i+1]){
                continue;
            }

            if(seen) return false;
            
            // in this case nums[i] > nums[i+1] ... 
            if( i>0 && nums[i]>nums[i+1]) // i=0 is because there is no n-1 element to check
                nums[i+1] = nums[i]; // or impove right


            seen = true;
        }

        return cnt<=1;
        
    }
}