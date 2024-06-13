// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        
        while(n/10!=0){
            
            
            int t = n;

            int sum=0;
            
            while(t!=0){
                int m = t%10;
                t/=10;
                sum+= m*m;
            }
            
            n = sum;
            
        }
        
        
        return n==1? true : false;
        
        
        
    }
}