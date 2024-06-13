// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
     
        // 今天比昨天厲害  https://www.youtube.com/watch?v=RJP0meMf5vg&t=407s
        
        int len = nums.length;
        int st =0, ed=len-1;
        while(st<=ed){
            
            int mid =  st +(ed-st)/2;
            
            int missingCnt = nums[mid]-nums[0]-mid;
            if(missingCnt < k){
                st = mid+1;
            }else{
                ed = mid-1;
            }
        }
        
        return nums[0] + k + st - 1;
        
        
      
    }
        
}