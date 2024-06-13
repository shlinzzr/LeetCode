// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
        
        int len = nums.length;
        int st =0, ed =len-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            System.out.println (st + " " + ed + " m=" + mid + " val= " + (nums[mid]-nums[0]-mid));
            
            if(nums[mid]-nums[0]-mid>k){
                ed = mid-1;
            }else{
                st = mid;
            }
        }
        
        return nums[0] + k + st ;
        
        
        
    }
}