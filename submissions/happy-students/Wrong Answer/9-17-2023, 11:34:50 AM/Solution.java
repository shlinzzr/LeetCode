// https://leetcode.com/problems/happy-students

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        
        int res = 0;
        
        if(nums.get(0)>0)
            res++;
        
        int curr = 0;
        
        for(int i=0; i<nums.size(); i++){
            
             curr+=1;
           
            if( curr+1<nums.get(i)){
                 // System.out.println(i +  " "+ curr + " less " + nums.get(i) );
                 res++;
            }
               
            
            if(curr>nums.get(i)){
            // System.out.println(i +  " "+ curr + " greater " + nums.get(i) );
              res++;
            }
            
            
              
            
        }
        
        return res;
        
        
    }
}