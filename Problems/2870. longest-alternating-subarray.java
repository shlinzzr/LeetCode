// https://leetcode.com/problems/longest-alternating-subarray

class Solution {
    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
      
        int max= -1;
     
        Integer p = null;
         // 2 3 4 3 4
        
        //[14,30,29,49,3,23,44,21,26,52]
        int cnt= 1;
        
        int st = -1;
        for(int i=0; i<len-1; i++){
            // 0 1 2
            int cur = nums[i]; // 29
            int nxt = nums[i+1]; //  49
        
            
            if( (p!=null && cur+p==nxt) ||  p==null && (cur+1==nxt) ){
                cnt++; //2
                max = Math.max(max, cnt); // 2
                
                if(p==null){
                    p =-1;
                }else{
                    p=-p;
                }
                
                
                
            }else{
                
                if(p!=null){
                     i--;
                    cnt = 1;
                    p=null;
                }
               
                
            }
            
            // System.out.println(i + " c=" + cur + " n=" +nxt + " m="+max);
            
        }
                  // System.out.println("max="+max);
               return max;
        
        
    }
}