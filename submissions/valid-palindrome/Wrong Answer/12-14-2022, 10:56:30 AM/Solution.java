// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        
        int st=0, ed=s.length()-1;
        
        while(st<ed){
            
            while(st<s.length() && !Character.isAlphabetic(s.charAt(st))){
                st++;
            }
            
            while(ed>=0 && !Character.isAlphabetic(s.charAt(ed))){
                ed--;
            }
            
            if(st>ed)
                return false;
            
            
            char ss = s.charAt(st);
            if(ss>='A' && ss<='Z'){
                ss = (char)((ss-'A')+'a');
            }
            
            char ee = s.charAt(ed);
            if(ee>='A' && ee<='Z'){
                ee = (char)((ee-'A')+'a');
            }
            
            
            if(ss!=ee)
                return false;
            
            st++;
            ed--;
            
        }
        
        return true;
        
        
    }
}