// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
       s = buildStr(s);
        t = buildStr(t);
        return s.equals(t);
    }
    
    
    private String buildStr(String s){
         int len = s.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(ch=='#'){
                if(sb.length()>0)
                    sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}