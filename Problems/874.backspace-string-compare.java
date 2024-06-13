// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        
        return compute(s).equals(compute(t));
    }
    
    private String compute(String s){
        
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            
            if(ch=='#'){
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else{
                sb.append(ch);
            }
            
        }
        
        return sb.toString();
        
    }
}