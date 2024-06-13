// https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int cnt =0 ;
        
        int len = nums.length;
        for(int i=0; i<len; i++){
            
             int c=1;
            for(int j=i;j<len;j++)
            {
                c=getLCM(c, nums[j]);
                cnt+=(c==k)?1:0;
            }
//             for(int j=i; j<len; j++){
                
//                 a = getLCM(1, nums[j]);
                
//                 if(a==k){
//                     cnt++;
//                 }else
//                     break;
//             }
        }
        
        return cnt;
        
    }
    
    
    private int getLCM(int a, int b){
        return (a*b)/getGCD(a, b);
    }
    
    private int getGCD(int a, int b){
        
        if(a==0)
            return b;
        
        return getGCD(b%a, a);
    }
}