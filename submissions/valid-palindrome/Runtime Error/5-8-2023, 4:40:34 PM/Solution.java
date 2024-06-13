// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        int st =0, ed = s.length()-1;
        
        s = s.toLowerCase();
        
        while(st<ed){
            while(!Character.isLetterOrDigit(s.charAt(st)))
                  st++;

            while(!Character.isLetterOrDigit(s.charAt(ed)))
                  ed--;
            // System.out.println(st + " " + ed);
            if(s.charAt(st++)!=s.charAt(ed--))
                  return false;
        }
        
                  
                  return true;
        
    }
}