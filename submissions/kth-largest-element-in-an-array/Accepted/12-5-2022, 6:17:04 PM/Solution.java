// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums, nums.length-k, 0, nums.length-1);
    }
    
    private int quickSelect(int[] nums, int k, int left, int right){
        
        int idx = partition(nums, left, right);
        if(idx==k)
            return nums[idx];
        else if(idx>k)
            return quickSelect(nums, k, left, idx-1);
        else 
            return quickSelect(nums, k, idx+1, right);
        
    }
    
    
     private int partition(int[] nums, int left, int right){
         
         int pivot = left; // this is key point
         int n = nums[pivot];
         while(left<=right){
             
             while( left<=right && nums[left]<=n) left++;   // this is key point with this "<=" condition, it will by pass pivot, to avoid pivot position chg.
             while( left<=right && nums[right]>n) right--;
             if(left<right)
                 swap(nums, left, right);
         }
         
         swap(nums, pivot, right);
         
         return right;
         
     }
    
    private void swap(int nums[], int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    
}