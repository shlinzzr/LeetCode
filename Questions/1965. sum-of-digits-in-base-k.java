// https://leetcode.com/problems/sum-of-digits-in-base-k

class Solution {
    public int sumBase(int n, int k) {
        
        int num = 0;
        while(n>0){
            
            num += n%k;
            n /= k;
        }
        
        return num;
        
    }
}