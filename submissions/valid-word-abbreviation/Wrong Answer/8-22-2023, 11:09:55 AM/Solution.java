// https://leetcode.com/problems/valid-word-abbreviation

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int idx = 0;
        
        
        
        for(int i=0; i<abbr.length(); i++){
            
            int skip = 0;
            
            char ch = abbr.charAt(i);
            
            if(Character.isDigit(ch)){
                if(ch=='0')
                    return false;
                
                int sum = ch-'0';
                
                
                int j=i+1;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    sum = sum*10 + (abbr.charAt(j++)-'0');
                }
                
                skip = sum;
                i=j-1;
                // System.out.println(skip + " " + i);
            }
            
            
            if(skip>0){
                idx += skip;  
                
                if(idx>word.length())
                    return false;
                
                // System.out.println("next: " + idx + " " + i);
                
                continue;
            }
            
            
             // System.out.println(word.charAt(idx) + " " + abbr.charAt(i));
            
            if(idx>=word.length())
                return false;
          
            if(word.charAt(idx++)!=abbr.charAt(i))
                return false;
        }
        
        return true;
        
        
    }
}