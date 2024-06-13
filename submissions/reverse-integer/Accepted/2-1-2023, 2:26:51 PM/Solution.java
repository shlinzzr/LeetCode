// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        
        int rev = 0, prev = 0;
        
        while(x!=0){
            rev = rev * 10 + x%10;
            
            if((rev-x%10)/10 != prev )
                return 0;
            
            prev = rev;
            x/=10;
        }
        
        return prev;        
    }
}