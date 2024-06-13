// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        int max = 0;
        String res = "";
        
        for(int i=0; i<len; i++){
            
            String odd = extend(s, i, i);
            if(odd.length()>res.length())
                res = odd;
            
            
            if(i+1<len){
                String even = extend(s, i, i+1);
                if(even.length()>res.length())
                    res = even;
            }
            
        }
        
        return res;
        
        
        
        
    }
    
    
    private String extend(String s , int st, int ed){
        
        while(st>=0 && ed<s.length()){
            if(s.charAt(st)==s.charAt(ed)){
                st--;
                ed++;
            }else
                break;
        }
        st++;
        ed--;
        return s.substring(st, ed+1);
        
    }
}