// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        
        String res = "";
        
        int len = s.length();
        for(int i=len; i>=1; i--){
            for(int j=0; j<len && j+i<=len; j++){
                
                if(ispal(s.substring(j, i+j)))
                    return s.substring(j, i+j);
            }
        }
        
        return res;
        
    }
    
    private boolean ispal(String s){
        int st = 0, ed=s.length()-1;
        while(st<ed){
            if(s.charAt(st)!=s.charAt(ed))
                return false;
            
            st++;ed--;
        }
        
        return true;
    }
}