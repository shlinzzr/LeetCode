// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int len = nums.length;
        int max =0;
        
        
        int cnt=0;
        
        
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            if(nums[ed]==1){
                max = Math.max(max, ed-st+1);
                
            }else{
                cnt++;
                while(cnt>k){
                    if(nums[st]==0)
                        cnt--;
                    st++;
                }
                max = Math.max(max, ed-st+1);
            }
            
        }
        
        return max;
        
        
        
        
        
        
        
        
//         int max = 0, zero = 0; // flip at most k zero
//         for (int st = 0, ed = 0; ed < nums.length; ed++) {
//             if (nums[ed] == 0)                                           
//                 zero++;
//             while (zero > k){
//                 if (nums[st++] == 0){
//                     zero--;                                     
//                 }
//             }
                    
//             max = Math.max(max, ed - st + 1);
//         }                                                               
//         return max;             
    }
    //     int max = 0, 
}

