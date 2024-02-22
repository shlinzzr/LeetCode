// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three

class Solution {
    public int averageValue(int[] nums) {
        
        int res = 0;
        int cnt = 0;
        for(int n: nums){
            if(n%6==0){
                res+=n;
                cnt++;
            }
        }
        
        
        
        return cnt==0 ? 0 : res/cnt;
        
    }
}