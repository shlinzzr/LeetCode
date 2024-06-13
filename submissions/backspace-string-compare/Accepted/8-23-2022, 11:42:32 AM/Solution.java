// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        
        
        int rm =0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c=='#'){
                rm++;
                continue;
            }
            
            if(rm>0){
                rm--;
                continue;
            }
            
            sb1.append(c);
            
        }
        
        
        StringBuilder sb2 = new StringBuilder();
         rm =0;
        for(int i=t.length()-1; i>=0; i--){
            char c = t.charAt(i);
            if(c=='#'){
                rm++;
                continue;
            }
            
            if(rm>0){
                rm--;
                continue;
            }
            
            sb2.append(c);
            
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}