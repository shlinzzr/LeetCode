// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {

        int len = nums.length;
        // find smallest first in arr;
        

        // [4,5,6,7,0,1,2]
        // st    mid     ed 
        // [0,1,2,4,5,6,7]
        
        // if(mid>ed) go right
        
        int st = 0, ed=len-1;
        while(st < ed){ //0, 1
            int mid = st + (ed-st)/2;  // 0
            if(nums[mid]>nums[ed]){
                st = mid+1; // 1
            }else{
                ed = mid; // 0
            }
        }

        return nums[st];




        
    }
}