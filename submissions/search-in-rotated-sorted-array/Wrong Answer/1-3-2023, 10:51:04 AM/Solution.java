// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        
        int len = nums.length;
        int st=0, ed=len-1;
        
        int offset = -1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==0){
                offset=mid;
                break;
                
            }else if(nums[mid]>0){
                
                if(nums[st]>nums[ed]){
                    if(nums[mid]>nums[st]){
                        st = mid+1;
                    }else{
                        ed = mid-1;
                    }
                }else{
                    ed =mid-1;
                }
            }
        }
        
        
        st=0; 
        ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            int _mid = (mid +offset)%len;
            
            if(nums[_mid]==target){
                return _mid;
            }else if(nums[_mid]>target){
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        
        return nums[st]==target ? st : -1;
        
        
    }
}