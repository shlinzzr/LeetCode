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
         
         int pivot = left;
         int n = nums[pivot];
         while(left<=right){
             
             while( left<=right && nums[left]<=n) left++;
             while( left<=right && nums[right]>n) right--;
             if(left<right)
                 swap(nums, left, right);
         }
         
         swap(nums, pivot, right);
         
         return right;
         
     }
    
    
    
//      private int partition(int[] nums, int left, int right){
         
//          int pivot = left+(right-left)/2;
//          int n = nums[pivot];
         
//          while(left<right){
             
//              while(left<right && nums[left]<=n) left++;
//              while(left<right && nums[right]>n) right--;
//              if(left<right)
//                  swap(nums, left, right);
//          }
         
//          swap(nums, pivot, right);
         
//          return right;
         
//      }
    
    
    
//     private int partition(int[] nums, int start, int end){
//         int pivot = nums[end];
//         int left = start;
//         for(int i = start; i < end; i++){
//             if(nums[i] < pivot){
//                 swap(nums, left, i);
//                 left++;
//             }
//         }
//         swap(nums, left, end);
        
//         return left;
        
        
//     }
    
    private void swap(int nums[], int left, int right){
        
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        
    }
    
    
    
    
}