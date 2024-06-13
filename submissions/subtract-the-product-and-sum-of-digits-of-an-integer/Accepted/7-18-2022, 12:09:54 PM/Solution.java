// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer

class Solution {
    public int subtractProductAndSum(int n) {
        
        int prod = 1;
        int sum=0;
        
        while(n>0){
            int nu = n%10;
            
            prod *= nu;
            sum += nu;
            
            n /= 10;
        }
        
        return prod-sum;
    }
}