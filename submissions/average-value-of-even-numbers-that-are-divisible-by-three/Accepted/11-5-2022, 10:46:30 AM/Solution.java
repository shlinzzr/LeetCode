// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three

class Solution {
    public int averageValue(int[] nums) {
        
        int t=0;
        int c=0;
        
        for(int n : nums){
        
            if(n%2==0 && n%3==0){
                t+=n;
                c++;
            }
        
        }
        
        if(c==0)return 0;
        return t/c;
    
    
    }
}