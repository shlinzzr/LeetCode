// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int cnt=0;
        
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(n%k==0)
                cnt++;
            if(i>0){
                if(gcd(n, nums[i-1])==k)
                    cnt++;
                
            }else if(i+1<nums.length){
                if(gcd(n, nums[i+1])==k)
                    cnt++;
            }
            
            
        }
        
        return cnt;
    }
    
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    
}