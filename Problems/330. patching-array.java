// https://leetcode.com/problems/patching-array

class Solution {
    public int minPatches(int[] nums, int n) {
        int len = nums.length;

        // https://www.youtube.com/watch?v=f0zzWwclhYQ

        long curr=0;
        int res=0;
        int idx=0;
        // [0, 1)

        while(curr<n){

            if(idx<len && nums[idx]<= curr+1){
                curr+= nums[idx];
                idx++;
            }else{
                res++;
                curr += curr+1;
            }

        }

        return res;
    }
}