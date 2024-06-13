// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch=='#' )
                if( sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
            else 
                sb.append(ch);
        }
        
        
        StringBuilder sbb = new StringBuilder();
        
        for(char ch : t.toCharArray()){
            if(ch=='#')
                if( sbb.length()>0)
                sbb.deleteCharAt(sbb.length()-1);
            else 
                sbb.append(ch);
        }
        
        return sb.toString().equals(sbb.toString());
        
    }
}