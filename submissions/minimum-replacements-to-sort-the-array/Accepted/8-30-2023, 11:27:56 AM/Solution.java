// https://leetcode.com/problems/minimum-replacements-to-sort-the-array

class Solution {
    public long minimumReplacement(int[] nums) {
        int len = nums.length;
        long res = 0;        
      
        
        for(int i=len-2; i>=0; i--){
            
            int x = (int)nums[i+1];
            int y = (int)nums[i];
            
            if(nums[i]<=nums[i+1]){
                continue;
            }
             
            long k=  y/x; 
            long d = y%x;
            if(d==0){
                res+=k-1;
                nums[i] = x;
                continue;
            }
            
            long p = (x-d) / (k+1);
            
            long x2 = x - p;
            long d2 = d + k*p;
            
            if (d2 < x2)
            {
                nums[i] =(int) x2-1;                
            }
            else
            {
                nums[i] = (int)d2;
            }
            res += k;
        }
        
        return res;
            
        
        
        
        
        
        // 3 9 4 => 3 3 3 3 4 => 
        
        
    }
}