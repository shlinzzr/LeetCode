// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        // Space O(1):
        return convert(s).equals(convert(t));
        
        // Space: O(M+N)
        // s = buildStr(s);
        // t = buildStr(t);
        // return s.equals(t);
    }
    
    
    private String convert(String s){
        
        int len = s.length();
        char[] arr = s.toCharArray();
        
        int i=0;
        for(int j=0; j<len; j++){
            
            char ch = arr[j];
            if(ch!='#'){
                arr[i]=arr[j];
                i++;
            }else{
                if(i>0){
                    i--;
                }
            }            
        }        
        
        return new String(arr).substring(0, i);
    }
    
    
    // Space: O(M+N)
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