// https://leetcode.com/problems/ugly-number

class Solution {
    public boolean isUgly(int n) {
        if(n==1)
            return true;
        
        int prev=0;
        
        while(n!=prev){
            prev=n;
            while(n%2==0)
                n/=2;
            while(n%5==0)
                n/=5;
            while(n%3==0)
                n/=3;
            
            if(n==1)
                return true;
        }
        
        return false;
        
    }
}