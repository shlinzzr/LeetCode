// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        
        int len = s.length();
        
        for(int i=0; i<len; i++){
            
            String odd = extend(s, i, i);
            if(odd.length()>res.length()){
                res=odd;
            }
            
            String even = extend(s, i, i+1);
            if(even.length()>res.length()){
                res=even;
            }
            
        }
        
        return res;
        
    }
    
    private String extend(String s, int st, int ed){
        
        while(st>=0 && ed<s.length() && s.charAt(st)==s.charAt(ed)){
            st--;
            ed++;
        }
        
        st++;
        ed--;
        return s.substring(st, ed+1);
        
    }
}