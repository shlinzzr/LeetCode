// https://leetcode.com/problems/sort-array-by-parity

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int len = nums.length;
        
        int idx= 0 ;
        for(int i=0; i<len; i++){

            if(nums[i]%2==0){
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                idx++;
            }
        }   

        return nums;

            
        
    }
}