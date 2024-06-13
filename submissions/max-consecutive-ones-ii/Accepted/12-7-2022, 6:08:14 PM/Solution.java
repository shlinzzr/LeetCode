// https://leetcode.com/problems/max-consecutive-ones-ii

class Solution {
   public int findMaxConsecutiveOnes(int[] nums) {
        int pos = -1, res = 0, runningSum = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                // System.out.println("i="+i + " pos="+pos);
                runningSum = i-pos;
                pos = i;
            }
            else runningSum++;
            res = Math.max(res, runningSum);
        }
        return res;        
    }
}