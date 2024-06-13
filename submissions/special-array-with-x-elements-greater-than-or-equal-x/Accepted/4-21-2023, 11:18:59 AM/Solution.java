// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x

class Solution {
    public int specialArray(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int st =0, ed=len;
        
        
        while(st<ed){
            
            int mid= ed-(ed-st)/2;
            int cnt = 0;    
            for(int n : nums){
                if(n>=mid){
                    cnt+=1;
                }
            }
            
            
            if(cnt>=mid){
                st = mid;
            }else{
                ed= mid-1;
            }
        }
        
        
        int cnt = 0;
         for(int n : nums){
                if(n>=st){
                    cnt+=1;
                }
            }
        
        if(st==cnt)
            return st;
        
        else
            return -1;
        
        
    }
}