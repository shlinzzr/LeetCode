// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
        
        
    }
    
    
    private int quickSelect(int[] nums, int left, int right, int k){
        
        if(left>right)
            return Integer.MAX_VALUE;
        
        int mid = left+(right-left)/2;
        int pivot=nums[mid];
        
        
        // System.out.println("mid="+mid);
        // System.out.println("p="+pivot);
       
        int idx = partition(nums, left, right);
        
        for(int n : nums)
            System.out.print(n + ", ");
        System.out.println(", idx="+idx);
        
        if(idx==k)
            return nums[idx];
        else if(idx>k){
            return quickSelect(nums, left, idx-1, k);    
        }else
            return quickSelect(nums, idx+1, right, k);
        
    }
    
    
    private int partition(int[] nums, int left, int right){
        
        int pivot = (left+right)/2;
        
        System.out.println(" l="+left + " r="+right + " pivot="+pivot);
        
        while(left<right){
            
            while( nums[left]<nums[pivot]){
                left++;
            }
            while( nums[right]>nums[pivot]){
                right--;
            }
            
            if(left<right){
                
                if(pivot==left)
                    pivot=right;
                else if(pivot==right)
                    pivot=left;
                
                swap(nums, left, right);
                left++;
                right--;
                
            }
        }
        
         System.out.println(" l="+left + " r="+right + " pivot="+pivot);
        
        
        swap(nums, left, pivot);
        
        return left;
    }
    
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;				
    }
}