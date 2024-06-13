// https://leetcode.com/problems/number-of-common-factors

class Solution {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        int cnt=0;
        
        for(int i=1; i<=gcd; i++){
            
            if(a%i==0 && b%i==0)
                cnt++;
            
        }
        return cnt;
        
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
        
    }
}