// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
//         Set<Integer> set = new TreeSet<>();
//         for(int n : nums){
//             set.add(n);
//         }
        
//         if(!set.contains(target)){
//             return new int[]{-1, -1};
//         }
        
        
        int len = nums.length;
        int st=0, ed=len-1;
        
        int left = -1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]<target){
                st = mid+1;
            }else{
                
                if(nums[mid]==target)
                    left=mid;
                ed = mid;
            }
        }
        
        ed=len-1;
        
        int right = -1;
        while(st<ed){
            
            int mid = (st+ed)/2+1;
            if(nums[mid]<=target){
                if(nums[mid]==target)
                    right=mid;
                st = mid ;
                
            }else{
                ed = mid-1;
            }
        }
        
        return new int[]{left, right};
        
        
        
        
    }
}