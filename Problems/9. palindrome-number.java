// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {

        int cp = 0;
        int temp = x;
        while(temp>0){
            int mod = temp%10;
            
            cp = cp*10+mod;
            
            temp/=10;
        }
        
        return cp==x;
        
        
    }
}