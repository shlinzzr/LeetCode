// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        // [0, n] => n+1 
        int len = nums.length;

        // vallen  will be change to the missing pos

        int idx= 0 ;
        for(int i=0; i<len; i++){
            int val = nums[i]; // val should be on the nums[val] except when val==len

            while(nums[i]<len && nums[nums[i]]!=nums[i]){
                swap(nums, i, nums[i]);
            }
        }

        for(int i=0; i<len; i++){
            if(nums[i]!=i) return i;
        }

        return len;
        
    }

    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}