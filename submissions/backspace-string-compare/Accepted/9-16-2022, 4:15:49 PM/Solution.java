// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
       return helper(s).equals(helper(t));
    }
    
    
    private String helper(String s){
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch!='#')
                sb1.append(ch);
            else if(sb1.length()>0){
                
                sb1.deleteCharAt(sb1.length()-1);
            }
        }
        
        return sb1.toString();
    }
}