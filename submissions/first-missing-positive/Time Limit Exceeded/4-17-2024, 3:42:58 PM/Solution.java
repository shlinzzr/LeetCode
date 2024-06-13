// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for(int i=0; i<len; i++){
            int val = nums[i]; // val should be at idx val-1
            if(nums[i]==i+1) continue;

            //if( nums[i] != i+1 ), it mean that nums[i] shound be at idx nums[i]-1
            while( nums[i]-1>=0 && nums[i]-1<len && nums[nums[i]-1]!=val){
                swap(nums, i, nums[i]-1);
            }

            
        }

        for(int i=0; i<len ;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return len+1;
        
    }


    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}