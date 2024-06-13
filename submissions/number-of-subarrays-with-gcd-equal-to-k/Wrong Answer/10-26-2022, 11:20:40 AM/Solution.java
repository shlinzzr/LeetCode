// https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int cnt=0;
        
        for(int n: nums){
            if(n%k==0)
                cnt++;
            
            
        }
        
        return cnt;
    }
}