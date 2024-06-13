// https://leetcode.com/problems/reverse-pairs

class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        int cnt =0 ;
        // bruteforce
        for(int j=0; j<len; j++){
            for(int i=0; i<j; i++){
                if((long)nums[i] > (long)2 * nums[j]){
                    cnt++;
                }

            }
        }

        return cnt;
    }
}