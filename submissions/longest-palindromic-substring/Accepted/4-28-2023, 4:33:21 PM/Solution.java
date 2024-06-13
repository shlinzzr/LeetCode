// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        
        for(int i=0; i<len; i++){
            
            String odd = extend(s, i, i);
            String even = extend(s, i, i+1);
            
            if(odd.length()>res.length()){
                res = odd;
            }
            
            if(even.length()>res.length()){
                res = even;
            }            
            
        }
        
        return res;
    }
    
    
    private String extend(String s, int st, int ed){
        
        while(st>=0 && ed<s.length() && s.charAt(st)==s.charAt(ed)){
            st--;
            ed++;
        }
        
        String res = s.substring(st+1, ed);
        return res;
    }
}