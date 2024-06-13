// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        if(len==1) return 0;
        
        if(len==2){
            if(nums[0]>nums[1]) return 0;
            else  return 1;
        }
        
        int st=0, ed=len-1;
        
        while(st<ed){ // 0, 1
            int m = st+(ed-st)/2; // 0
            
            if(nums[m-1] < nums[m] && nums[m]>nums[m+1]){
                return m;
            }else if(m+1<len && nums[m]< nums[m+1]){
                st = m+1; // 1
                
            }else if(m-1 >=0 && nums[m-1] >nums[m]){ // m >= m+1
                ed = m-1; // -1
            }
        }
        
        return st;
    }
    
    
    //[1,2,1,3,5,6,4]
         // st  m   ed
    
    //[6,5,4,3,2,3,2]
    
}