// https://leetcode.com/problems/next-permutation

class Solution {
    
    //https://www.youtube.com/watch?v=IbcQOdtmvpA
    
    // 他媽的 這只能背了吧 幹
    
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        int i=len-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        if(i>=0){
            int j=len-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            
            swap(nums, i, j);
        }
        
        reverse(nums, i+1, len-1);
        
        
        
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    
    private void reverse(int[] nums, int i, int j){
        
        
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
        
    }
}