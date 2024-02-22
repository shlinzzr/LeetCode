// https://leetcode.com/problems/factorial-trailing-zeroes

class Solution {
    public int trailingZeroes(int n) {
        
        
        int cnt= 0 ;
        for(int i=1; i<=n; i++){
            if(i%5==0){
                int t = i;
                
                while(t%5==0){
                    t/=5;
                    cnt++;
                }
            }
        }
        
        return cnt;


    }
}