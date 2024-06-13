// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int val = x;

        int rev = 0;

        while(val>0){
            rev = rev*10 + val%10;
            val/=10;
        }

        return rev==x;


        
    }
}