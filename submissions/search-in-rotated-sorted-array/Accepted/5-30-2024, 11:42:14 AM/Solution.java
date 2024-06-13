// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;

        int st=0, ed=len-1;

        while(st<ed){//0 , 1

            int mid = st+(ed-st)/2; // 0

            if(nums[mid]>nums[ed]){
                st = mid+1; // 1
            }else{
                ed = mid; //0
            }
        }

        int offset = st;

        st=0; ed=len-1;
        while(st<ed){ //0 , 1
            int mid = st+(ed-st)/2; // 0

            int idx = (mid+offset+len)%len;

            if(nums[idx]==target) return idx;
            else if(nums[idx]>target){
                ed = mid-1; // -1
            }else{
                st = mid+1; // 1
            }
        }

        int idx = (st+offset+len)%len; 
        if(nums[idx]==target) return idx;

        return -1;




        
    }
}