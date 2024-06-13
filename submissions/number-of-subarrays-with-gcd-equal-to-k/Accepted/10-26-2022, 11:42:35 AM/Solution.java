// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int cnt=0;
        
        for(int i=0; i<nums.length; i++){
           for(int j=i; j<nums.length && nums[j]%k==0; j++){
               nums[i] = gcd (nums[i], nums[j]);
               if(nums[i]==k)
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