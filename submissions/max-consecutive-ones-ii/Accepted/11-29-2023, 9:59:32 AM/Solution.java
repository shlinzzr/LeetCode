// https://leetcode.com/problems/max-consecutive-ones-ii

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;

        int st =0, zcnt =0, max=0;
        for(int i=0; i<len; i++){

            if(nums[i]==0)
                zcnt++;

            while(zcnt>1){
                if(nums[st]==0){
                    zcnt--;
                }
                st++;
            }

            max = Math.max(max, i-st+1);
        }

        return max;
    }
}