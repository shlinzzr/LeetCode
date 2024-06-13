// https://leetcode.com/problems/ternary-expression-parser

class Solution {
    public String parseTernary(String ex) {
        
        System.out.println(ex);
        
        
        int len = ex.length();
        
        if(len==1)
            return ex;
        
        for(int i=0; i<len; i++){
            
            if(ex.charAt(i)=='T')
                return parseTernary ( ex.substring(i+2, ex.lastIndexOf(":")) );

            if(ex.charAt(i)=='F')
                return parseTernary ( ex.substring(ex.indexOf(":")+1) );
        }
        
        return ex;
        
    }
}