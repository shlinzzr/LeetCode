// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {

        int len = nums.length;
        int cnt = 0;
        // non-desc
        // equal or asc
        for(int i=0; i<len-1; i++){

            if(nums[i]<=nums[i+1]){
                continue;
            }else{
                cnt++;
            }
        }

        return cnt<=1;
        
    }
}