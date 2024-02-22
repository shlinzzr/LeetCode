// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer

class Solution {
    public int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        
        int sum=0;
        int prod=1;
        for(int i=0; i<s.length(); i++){
            
            int d = s.charAt(i)-'0';
            
            sum+=d;
            prod*=d;
        }
        
        return prod-sum;
        
    }
}