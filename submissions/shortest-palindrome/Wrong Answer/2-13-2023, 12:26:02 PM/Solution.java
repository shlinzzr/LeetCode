// https://leetcode.com/problems/shortest-palindrome

class Solution {
    public String shortestPalindrome(String s) {
        
        int len = s.length();
        
        for(int i=len/2;i>=0; i--){
            
            String odd = extend(s, i, i);    
            if(odd!=null)
                return odd;
            
            
            String even = extend(s, i, i+1);
            if(even!=null)
                return even;
        }
        
        return "";
        
    }
    
    private String extend(String s, int st, int ed){
        
        while(st>=0 && ed<s.length() &&s.charAt(st)==s.charAt(ed)){
            st--;
            ed++;
        }
        if(st>0)
            return null;
        
        
        StringBuilder sb = new StringBuilder();
        while(ed<s.length()){
            sb.append(s.charAt(ed));
            ed++;
        }
        
        sb.append(s);
        return sb.toString();
            
        
    }
}