// https://leetcode.com/problems/ugly-number-ii

class Solution {
    public int nthUglyNumber(int n) {
        
        int i=0;
        
        while(n>0){
            i++;
            if(i==1 || i%2==0 || i%3==0 || i%5==0){
                n--;    
            }
        }
        
        return i;
        
    }
}