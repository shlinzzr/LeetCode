// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        int st=0; 
        for(int ed=0; ed<len; ed++){
            
            if(nums[ed]==1)
                continue;
            
            // nums[ed]==0

            
            
            
            q.offer(ed+1); //  5 6
            k--;
            
            //ed=3 q=[4] k=1
            //ed=4 q=[4,5] k=0
            //ed=5 q=[5,6] k=0
            //ed=10 q=[6,10]
            if(k>0){
                continue;
            }
            
            if(k==0){
                max = Math.max(max, ed-st+1);   
                st = q.poll();
                k++;
                
                // max=5, st=4, k=1
                // max =max(2,5) = 5, st=5, k=1
                // max= max(10-5+1)=6, st=10
                
                
                
            }
                
        }
        
        while(!q.isEmpty() && k>0){
            max = Math.max(max, len-q.poll());
            k--;
        }
        
        
        
        return max;
        
    }
    
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