// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
     
        int len = nums.length;
        if(len==1 && nums[0]==target)
            return true;
        
        
        // find min 
        int st = 0, ed=len-1;
        
        while(st<ed){
            
            // # shifting to remove duplicate elements
            while( st<ed && nums[st] == nums[st+1] && nums[st]>=nums[ed])
                st+=1;
            while( st<ed && nums[ed] == nums[ed-1])
                ed-=1;
            
            if(st>=ed)
                break;
            System.out.println(st + " "+ed);
            int mid = st+(ed-st)/2;
            
            if(nums[mid]>nums[ed]){
                st=mid+1;
            }else{
                ed=mid;
            }
        }
        
        int fidx = st;
        System.out.println(fidx);
        
        st=0;
        ed=len-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            int tran = (mid+fidx)%len;
            
            if(nums[tran]==target)
                return true;
            else if(nums[tran]<target){
                st = mid+1;
            }else{
                ed=mid-1;
            }
        }
        
        
        return nums[(st+fidx)%len]==target;
        
        
        
        
    }
}