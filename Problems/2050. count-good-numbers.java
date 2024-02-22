// https://leetcode.com/problems/count-good-numbers

class Solution {
    
    int M = (int) 1e9+7;
    
    // prime : 2 3 5 7 
    // even  : 0 2 4 6 8
    
    
    public int countGoodNumbers(long n) {
                    // even                      // odd
        return (int)(power(5, (n + 1) / 2) * power(4, n / 2) % M);    
    }
    
//     public long modPow(long x, long y)
//     {
//         if (y == 0)
//             return 1;
        
//         long p = modPow(x, y / 2);
//         return p * p * (y % 2 > 0 ? x : 1) % M;
//     }
    
    
    public long power(long x,long y){ 
        
        if(y==0) 
            return 1;
        long temp = power(x,y/2);
        
        if(y%2==0) 
            return (temp*temp)%M; 
        else 
            return (x*temp*temp)%M;
    }
    
    
    
    
}