// https://leetcode.com/problems/count-alternating-subarrays

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        
        int len = nums.length;
        long res= 0 ;
        
        int ed =0;
        
        for(int st= 0; st<len; st++){
            
            while(ed<len && (st==ed || nums[ed]!= nums[ed-1])){
              
                res += ed-st+1;
                
                ed++;
                
                // System.out.println(st + " " + ed + " res="+res);
            }
            
            st=ed-1;
        }
        
        return res;
        
    }
    // [1 0 1]1
    // st    ed
}