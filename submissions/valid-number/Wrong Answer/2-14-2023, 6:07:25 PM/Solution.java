// https://leetcode.com/problems/valid-number

class Solution {
    public boolean isNumber(String s) {
        if(s.length()==0)
            return false;        
        
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            
            if(s.length()<2)
                return false;
            
            if(s.charAt(1)=='-' || s.charAt(1)=='+')
                return false;
            
            return isNumber(s.substring(1, s.length()));
        }
            
        
        char prev = '+';
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
                continue;
            
            if((ch=='+' || ch=='-') && prev!='e' && prev!='E')
                return false;
            
            if(ch=='.' && i==s.length()-1)
                return false;
            
            
            if((ch=='E' || ch=='e') && i<s.length()-1 && Character.isDigit(prev))
                continue;
            
            if(ch-'a'<=0 || ch-'a'>25)
                return false;
            
            prev=ch;
        }
        
        return true;
        
        
    }
}