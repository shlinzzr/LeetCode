// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        //quickSelect? => xx , ans is index sorting 
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    return i+1;
        }
        return nums.length+1;
        
        
            
        
        
        
        
//         int st=0, ed=nums.length-1;
//         quickSelect(nums, st, ed);
        
    }
    
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;    
    }
    
    
    
//     private int quickSelect(int nums[], int st, ed){
        
//         int pivot = st;
        
//         int pivotIdx = helper(nums, st, ed);
//         if(nums[pivotIdx]<=0){
//             if(pivotIdx+1 < nums.length && nums[pivotIdx+1]>0){
//                 int k=1;
//                 while(pivot+1<nums.length){
//                     nums[pivot]!=
//                 }
//             }
            
            
//         }
//             quickSelect(nums, pivotIdx+1, ed);
//         else if()
        
        
        
//     }
    
//     private int helper(int nums[], int st, int ed){
//         int pivot = st;
        
//         while(st<ed){
//             while(nums[st]<=nums[pivot]){
//                 st++;
//             }
//             while(nums[ed]>nums[pivot]){
//                 ed--;
//             }

//             int temp = nums[st];
//             nums[st] = nums[ed];
//             nums[st] = temp;    
//         }
        
        
//         int temp = nums[pivot];
//         nums[pivot] = nums[ed];
//         nums[ed] = temp;    
        
//         return ed;
        
//     }
    
    
}