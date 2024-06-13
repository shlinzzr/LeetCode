// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickselect(nums, 0, len-1, len-k);
        
        return nums[len-k];
    }
    
    private void quickselect(int[] nums, int left, int right, int k){
        
        if(left>=right) return;
        
        int pivotIdx = partition(nums, left, right-1, right);
        swap(nums, pivotIdx, right);
        
        if(k==pivotIdx) return;
        else if(k<pivotIdx){
            quickselect(nums, left, pivotIdx-1, k);
        }else {
            quickselect(nums, pivotIdx+1, right, k);
        }
            
    }
    
    private int partition(int[] nums, int left, int right, int pivot){
        while(left<=right){
            if(nums[left]>nums[pivot]){
                swap(nums, left, right);
                right--;
            }else
                left++;
        }
        return left;
    }
    
    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}