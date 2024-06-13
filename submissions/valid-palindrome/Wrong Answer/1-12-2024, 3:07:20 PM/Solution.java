// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        
        int len = s.length();
        int st=0, ed=len-1;
        
        while(st<ed){
            
            while(st<len && !('a'<=s.charAt(st)&& s.charAt(st)<='z') &&  !('A'<=s.charAt(st)&& s.charAt(st)<='Z')  ){ 
                st++;
            
        }
            
             while( ed>=0 && !('a'<=s.charAt(ed)&& s.charAt(ed)<='z') && !('A'<=s.charAt(ed)&& s.charAt(ed)<='Z')  ){ 
                ed--;
        }
            
            if(st>=ed) return true;
            
            int a = ('a'<=s.charAt(st)&& s.charAt(st)<='z') ? s.charAt(st)-'a' : s.charAt(st)-'A';
            int b = ('a'<=s.charAt(ed)&& s.charAt(ed)<='z') ? s.charAt(ed)-'a' : s.charAt(ed)-'A';

            if(a!=b) return false;

            st++;
            ed--;
        }
        return true;
            
                    
    }
}