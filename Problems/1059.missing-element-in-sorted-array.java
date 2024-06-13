// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
        int len = nums.length;
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            int missingCnt = nums[mid]-nums[0]-mid;
            
            if(missingCnt<k){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        int missingCnt = nums[st]-nums[0]-st;
            
        if(missingCnt<k){
            st = st+1;
        }else{
            ed = st;
        }
        
        
        
        return nums[0] + k + st -1;
        
        
        
    }
}