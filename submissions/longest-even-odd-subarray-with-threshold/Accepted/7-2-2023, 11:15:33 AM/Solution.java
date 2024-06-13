// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        
        int max =0;
        
        int st=0;
        
        
        while(st<len && (nums[st]%2==1 || nums[st]>threshold))
            st++;
        
        for(int ed=st; ed<len; ed++){
            
            if(nums[ed]>threshold){
                st=ed;
                while(st<len && (nums[st]%2==1 || nums[st]>threshold))
                    st++;
                  
                ed=st-1;
                
                System.out.println(st + " " + ed+1);
                continue;
            }
            
            
            if(ed-st>0 && (nums[ed-1]+nums[ed])%2==0){
                
                st=ed;
                while(st<len && (nums[st]%2==1 || nums[st]>threshold))
                    st++;
                
                ed=st-1;
                
                continue;
            }
            
            
            max = Math.max(max, ed-st+1);
            
        
        
        
        }
        
        return max;
        
        
    }
}