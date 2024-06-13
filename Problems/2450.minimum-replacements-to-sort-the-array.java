// https://leetcode.com/problems/minimum-replacements-to-sort-the-array

class Solution {
    public long minimumReplacement(int[] nums) {
        int len = nums.length;
        long res = 0;        
      
        
        // o o o o o y x
        // o o o o o | d x x x x x x | x
        //                 k copies
        
        for(int i=len-2; i>=0; i--){
            
            int x = (int)nums[i+1];
            int y = (int)nums[i];
            
            if(y<=x){
                continue;
            }
             
            long k = y/x; 
            long d = y%x;
            
            if(d==0){
                res+=k-1;
                nums[i] = x;
                continue;
            }
            
            
            // p 每個x砍p刀給d 變成 (x-p)
            
            // d有上限 : d+k*p <= x-p
            //  =>  d + (k+1)*p <= x
            long p = (x-d) / (k+1);
            
            long x2 = x - p;
            long d2 = d + k*p;
            
            if (d2 < x2) // 還可以再微調 砍partial x2 給d 所以max 變成x2-1
            {
                nums[i] =(int)x2-1;                
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