// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
       
        int len = s.length();
        for(int i=1; i<=len/2; i++){
            
            if(len%i==0){
                
                String sub = s.substring(0, i);
                int r = len/i;
                
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<r; j++){
                    sb.append(sub);
                }
                
                if(sb.toString().equals(s))
                    return true;
            }
        }
        
        return false;
        
        // aaa aaa aaa aaa aaa
        // aaaa aaaa aaaa
    
    }
}