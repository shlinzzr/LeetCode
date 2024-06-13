// https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation

class Solution {
    public String smallestString(String s) {
        int len = s.length();
       
        int st =0;
        while(st<len){
            
            char ch = s.charAt(st);
            
            if(ch>'a'){
                
                int ed=st;
                
                while(ed<len && s.charAt(ed)>'a'){
                    ed++;
                }
                
                
                s = T(s, st, ed);
                break;
            }
            
            st++;
            
            
        }
        
        return s;
        
       
    }
    
    
    private String T(String s ,int st, int ed){
         int len = s.length();
        char[] res = s.toCharArray();
        
        for(int i=st; i<ed; i++){
               char ch = s.charAt(i);
            
            char tmp = (char) (((ch-'a')+25)%26 + 'a');
            
            res[i] = tmp;
        }
       
        
         return new String(res);
        
    }
}