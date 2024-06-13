// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {

        int len = nums.length;
        int cnt = 0;
        // non-desc
        // equal or asc

        int min = nums[1];
        for(int i=0; i<len-1; i++){

            if(nums[i]<=nums[i+1]){
                min = Math.min(min, nums[i]);
                continue;
            }else{

                if(nums[i+1]<min) return false;
                cnt++;
            }
        }

        return cnt<=1;
        
    }
}