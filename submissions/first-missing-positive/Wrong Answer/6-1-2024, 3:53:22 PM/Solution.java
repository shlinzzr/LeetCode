// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for(int i=0; i<len ; i++){
            int val = nums[i];
            // val should be @ idx val-1 => swap (i, val-1)

            while(nums[i]-1<len && nums[i]-1>=0 && nums[nums[i]-1]!=nums[i]){
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0; i<len; i++){
            if(nums[i]!=i+1)return i+1;
        }

        return len;
        
    }

    private void swap(int[] nums, int i, int j){
        int t= nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}