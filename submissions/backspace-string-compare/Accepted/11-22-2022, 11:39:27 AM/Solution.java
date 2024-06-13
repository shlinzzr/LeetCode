// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch!='#' )
                sb.append(ch);
            else
                 if( sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
                
        }
        
        
        StringBuilder sbb = new StringBuilder();
        
        for(char ch : t.toCharArray()){
            if(ch!='#')
                sbb.append(ch);
            else
                if( sbb.length()>0)
                sbb.deleteCharAt(sbb.length()-1);
                
        }
        
        return sb.toString().equals(sbb.toString());
        
    }
}