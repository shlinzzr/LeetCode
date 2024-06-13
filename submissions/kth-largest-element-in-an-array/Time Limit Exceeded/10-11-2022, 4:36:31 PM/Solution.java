// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
        
        
    }
    
    
    private int quickSelect(int[] nums, int left, int right, int k){
        
        if(left>right)
            return -1;
        
        int mid = left+(right-left)/2;
        int pivot=nums[mid];
        int idx = partition(nums, left, right, mid);
        
        for(int n : nums)
            System.out.print(n + ", ");
        
        System.out.println(", idx="+idx);
        
        if(idx==k)
            return nums[idx];
        else if(idx>k){
            return quickSelect(nums, left, idx, k);    
        }else
            return quickSelect(nums, idx+1, right, k);
        
    }
    
    
    private int partition(int[] nums, int left, int right, int mid){
        
        int pivot = nums[mid];
        
        
        while(left<right){
            
            while(nums[left]<pivot){
                left++;
            }
            while(nums[right]>pivot){
                right--;
            }
            
            if(left<right){
                
                if(left==mid)
                    mid=right;
                
                else if(right==mid)
                    mid=left;
                
                swap(nums, left, right);
                left++;
                right--;
            }
        }
            
        swap(nums, left, mid);
        
        return left;
    }
    
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;				
    }
}