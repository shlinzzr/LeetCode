// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
        
        int len = nums.length;
        int st =0, ed =len-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            // System.out.println (st + " " + ed + " m=" + mid + " val= " + (nums[mid]-nums[0]-mid));
            int val = nums[mid]-nums[0] - mid; // 0到mid有幾個missing number
            
            if(nums[mid]-nums[0]-mid>k){  // >k  往左收斂
                ed = mid-1;
            }else{   // 往右收斂
                st = mid;
            }
        }
        
        
        return nums[0] + k + st ;
        
    }
}