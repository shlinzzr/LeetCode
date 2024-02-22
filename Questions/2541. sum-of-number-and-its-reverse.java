// https://leetcode.com/problems/sum-of-number-and-its-reverse

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        // abcde
        // edcba
        
        // a+e b+d c+c b+d a+e
        
        // abcd
        //.dcba
        // a+d b+c c+b a+d
        
        // first digit : 0~18
        
        
        for(int i=0; i<=num; i++){
            
            if(i + rev(i)==num)
                return true;
                
        }
        
        return false;
        
        
    }
    
    private int rev(int n){
        int res =0;
        
        while(n>0){
            res*=10;
            res += n%10;
            n/=10;
        }
        
        return res;
        
        
    }
}