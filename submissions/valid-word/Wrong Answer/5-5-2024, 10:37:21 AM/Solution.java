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
        
        for(char ch : word.toCharArray()){
            
            
            if(Character.isDigit(ch))
                bool[0]= true;
            
            
            
            if(ch>='a' && ch<='z'){
                
                   bool[1] = true;
                
                 if(set.contains(ch)){
                    bool[3] = true;
                }else{
                    bool[4] = true;
                }
            
            }
            
             
            if(ch>='A' && ch<='Z'){
                 bool[2] = true;
                
                  if(set.contains(ch)){
                    bool[3] = true;
                }else{
                    bool[4] = true;
                }
            
            }
        }
        
        for(int i=0; i<5; i++){
            if(bool[i]==false) return false;
        }
        
        return true;
        
    }
}