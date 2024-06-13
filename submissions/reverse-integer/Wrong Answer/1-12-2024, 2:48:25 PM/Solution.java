// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int t=0;
        while(x>0){
            t= t*10 + x%10;
            x/=10;
        }
        
        return t;
        
    }
}