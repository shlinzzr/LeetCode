// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        if(len==1) return 0;
        
        int st=1, ed=len-2;
        
        while(st<ed){ // 0, 1
            int m = st+(ed-st)/2; // 0
            
            if(nums[m-1] < nums[m] && nums[m]>nums[m+1]){
                return m;
            }else if(nums[m]< nums[m+1]){
                st = m+1; // 1
            }else{ // m >= m+1
                ed = m-1; // -1
            }
        }
        
        return st;
    }
    
    
    //[1,2,1,3,5,6,4]
         // st  m   ed
    
}