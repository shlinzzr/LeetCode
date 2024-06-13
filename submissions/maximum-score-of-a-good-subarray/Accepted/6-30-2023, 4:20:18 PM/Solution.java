// https://leetcode.com/problems/maximum-score-of-a-good-subarray

class Solution {
    public int maximumScore(int[] nums, int k) {
       
        
        // int n = nums.length;
        // int l = k, r = k;
        // int minVal = nums[k];
        // int ret = 0;
        // while (l>=0 || r < n)
        // {
        //     while (l>=0 && nums[l]>=minVal) l--;
        //     while (r<n && nums[r]>=minVal) r++;
        //     ret = Math.max(ret, (r-l-1)*minVal);            
        //     minVal = Math.max(l>=0?nums[l]:Integer.MIN_VALUE, r<n?nums[r]:Integer.MIN_VALUE);            
        // }
        // return ret;
        
        int len = nums.length;        
        int st=k, ed=k;
        int min = nums[k];
        int max = 0;
        
        while(st>=0 || ed<len){
            
            while(st>=0 && nums[st]>=min) st--;
            while(ed<len && nums[ed]>=min) ed++;
            max = Math.max(max, min*(ed-st-1));
            min = Math.max(st>=0?nums[st]:Integer.MIN_VALUE, ed<len? nums[ed]:Integer.MIN_VALUE );
        }
        
        return max;
    }
}
        
            
         
          
            
//             if(st>0 && nums[st]>=nums[ed] || ed==len-1){
//                 st--;
//                 min = Math.min(min, nums[st]);
                
//             }else{
//                 ed++;
//                 min = Math.min(min, nums[ed]);
//             }
            
//             max = Math.max(max, min*(ed-st+1));
            
        // }
                           
        
        
