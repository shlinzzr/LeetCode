// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int len = nums.length;
        
        
        long res = 0;
        for(int st=0; st<len; st++){
            
            if(nums[st]%k!=0)
                continue;
            
            for(int ed=st; ed<len && nums[ed]%k == 0; ed++){
                
                nums[st] = gcd(nums[st], nums[ed]);
              
                if(nums[st]==k)
                    res+=1;
                
            }
        }
        
        return (int)res;
        
    }
    
    // a>b
    private int gcd(int a, int b){
        
        if(b==0) return a;
            
        return gcd(b, a%b);
    }
}