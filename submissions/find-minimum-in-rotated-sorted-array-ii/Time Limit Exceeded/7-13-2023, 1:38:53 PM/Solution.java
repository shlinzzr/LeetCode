// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        int st=0;
        int ed = len-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            while(mid+1<len && nums[mid+1]==nums[mid]){
                mid++;
            }
            
            
            if(nums[mid]>nums[ed]  || (mid+1<len && nums[mid]>nums[mid+1])){
                
                st = mid +1;
            }else{
                ed= mid;
            }
        }
        
        return nums[st];
    }
}