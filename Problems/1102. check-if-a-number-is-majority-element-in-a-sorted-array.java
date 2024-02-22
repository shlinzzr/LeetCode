// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = fisrt(nums, target);
        int plusNBy2Index = firstIndex + nums.length/2;
        
        if (plusNBy2Index<nums.length 
            && nums[plusNBy2Index] == target) {
            return true;
        }
        
        return false;
    }
    
//     private int firstOccur(int[] nums, int target) {
//         int low = 0;
//         int high = nums.length;
//         while (low < high) {
//             int mid = low + (high-low)/2;
//             if (nums[mid] < target) low = mid + 1;
//             else if (nums[mid] >= target) high = mid;
//         }
//         return low;
//     }
    
    
    private int fisrt(int[] nums, int target){
        int st =0, ed =nums.length-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(nums[mid]<target){
                st=mid+1;
            }else{
                ed=mid;
            }
        }
        
        return st;
    }
    
}