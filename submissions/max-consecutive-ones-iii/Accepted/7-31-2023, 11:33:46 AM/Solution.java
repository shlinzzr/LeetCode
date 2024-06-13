// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        
        int len = nums.length;
        int st =0;
        
        int max= 0;
        
        int flip=0;
        for(int ed=0; ed<len;ed++){
            
            if(nums[ed]==0)
                flip++;
            
            while(flip>k){
                
                if(nums[st++]==0)
                    flip--;
            }
            
            max = Math.max(max, ed-st+1);
            
        }
        
        return max;
        
        
//         int max = 0;
//         int st=0;
//         int z = 0;
//         for(int ed=0; ed<nums.length; ed++){
            
//             if(nums[ed]==0)
//                 z++;
            
//             while(z>k){
//                 if(nums[st++]==0){
//                     z--;
//                 }
                
                
//             }
            
//             max = Math.max(max, ed-st+1);
//         }
        
//         return max;
        
        
    }
    /*class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, zero = 0; // flip at most k zero
        for (int st = 0, ed = 0; ed < nums.length; ed++) {
            if (nums[ed] == 0)                                           
                zero++;
            while (zero > k){
                if (nums[st++] == 0){
                    zero--;                                     
                }
            }
                    
            max = Math.max(max, ed - st + 1);
        }                                                               
        return max;             
    }
    //     int max = 0, 
}
*/
    /*
    
    [1,1,1,0,0,0,1,1,1,1,0], k = 2
           ^ ^  q=[4,5], k==0, ed=4, st=0,
           
           
    ed=5, k=0, st=0:       
    [1,1,1,0,0, 0,1,1,1,1,0], 
       max = 5-0==5 st=q.poll()=
             
              
              
    [1,1,1,0, 0, 0,1,1,1,1,0], k = 1           
              st           ^ q=[5,len] max=10-4==6, k=1;
              
              
              
    
    */
}