// https://leetcode.com/problems/valid-word

class Solution {
    public boolean isValid(String word) {
        
        if(word.length()<3) return false;
    
        Set<Character> set = new HashSet<>();
        set.add('a');
         set.add('e');
         set.add('i');
         set.add('o');
         set.add('u');
        
           set.add('A');
         set.add('E');
         set.add('I');
         set.add('O');
         set.add('U');
        
        boolean[] bool = new boolean[5]; // 0-9/ a-z, A-Z, v, not v
        
        bool[0] = true;
         bool[1] = true;
        bool[2] = true;
        
        for(char ch : word.toCharArray()){
            
            
            if(!Character.isDigit(ch) && (ch<='a' && ch>='z') && (ch<='A' && ch>='Z'))
                return false;
            
            if(Character.isDigit(ch))
                 continue;
            
            
            
            if(ch>='a' && ch<='z'){
                
                  
                
                 if(set.contains(ch)){
                    bool[3] = true;
                }else{
                    bool[4] = true;
                }
                
                  continue;
            
            }
            
             
            if(ch>='A' && ch<='Z'){
                 
                
                  if(set.contains(ch)){
                    bool[3] = true;
                }else{
                    bool[4] = true;
                }
                
                
                continue;
            
            }
            
            return false;
        }
        
        for(int i=0; i<5; i++){
            if(bool[i]==false) return false;
        }
        
        return true;
        
    }
}