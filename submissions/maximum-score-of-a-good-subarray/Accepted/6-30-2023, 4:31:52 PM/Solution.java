// https://leetcode.com/problems/maximum-score-of-a-good-subarray

class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int len = nums.length;        
        int st=k, ed=k;
        int min = nums[k];
        int max = nums[k];
        
        while(st>0 || ed<len-1){
            
            while(st>=0 && nums[st]>=min) st--;
            while(ed<len && nums[ed]>=min) ed++;
            max = Math.max(max, min*(ed-st-1));
            min = Math.max(st>=0?nums[st]:Integer.MIN_VALUE, ed<len? nums[ed]:Integer.MIN_VALUE );
        }
        
        return max;
    }
}
        
            
         
          
//         while(st>=0 || ed<len){
            
//             min = Math.max(st>=0?nums[st]:Integer.MIN_VALUE, ed<len? nums[ed]:Integer.MIN_VALUE );
            
//             if( (st>0 && nums[st-1]>=nums[ed]) || ed>=len-1){
                
//                 System.out.println(st + " " +ed);
//                 min = Math.min(min, nums[st-1]);
//                 st--;
//             }else{

//                 min = Math.min(min, nums[ed+1]);
//                 ed++;
//             }
            
//             max = Math.max(max, min*(ed-st));
            
//         }
        
//         return max;
                      
//     }
// }
        
        
