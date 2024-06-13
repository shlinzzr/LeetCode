// https://leetcode.com/problems/frequency-of-the-most-frequent-element

class Solution {
    
    
    //https://www.youtube.com/watch?v=c-Jt5jFKNv0
    
    public int maxFrequency(int[] nums, int k) {
        int max = 1;
        Arrays.sort(nums);
        int len = nums.length;
        
        long curr =0;
        
        int st= 0 ;
        for(int ed =1; ed<len; ed++){
            
            curr =+ (long) (ed-st)*(nums[ed]-nums[ed-1]);
            while(curr>k){
                
                curr-=(nums[ed]-nums[st]);
                st++;
            }
            
            max = Math.max(max, ed-st+1);
            
            
        }
        
        return max;
        
        /*
        x x x x x [st x x ed-1, ed] window sum<k
                             ^
        when the ref "ed-1" need expand to "ed" : sum += (ed-1-st+1)*(nums[ed]-nums[ed-1])                     
                             
        if(sum>k)
            sum-=nums[ed]-nums[st];
        */
        
    }
    
    
}