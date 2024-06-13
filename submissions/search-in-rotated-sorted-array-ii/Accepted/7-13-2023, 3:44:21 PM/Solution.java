// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
        
        
       int len = nums.length;
        
        int st=0;
        int ed=len-1;
        
        while(st<ed && nums[st]==nums[ed] ){
            ed--;
        }
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==target)
                return true;
            
            if(nums[mid]>=nums[0] == target>=nums[0]){ // 判斷是不是同一鞭
                
                if(nums[mid]<target){
                    
                    st=mid+1;
                }else{
                    ed=mid-1;
                }
            }else if(target>=nums[0]){ // 用target 來判斷是哪一鞭
                
                ed=mid-1;
            }else{
                st = mid+1;
            }
        }
        
        if(st==ed && nums[st]==target){
            return true;
        }

        return false;
    }
    
}