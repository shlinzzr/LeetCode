// https://leetcode.com/problems/string-transforms-into-another-string

class Solution {
    public boolean canConvert(String str1, String str2) {
        
        if(str1.equals(str2)) return true;
        if(str1.length()!=str2.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        
        for(int i=0; i<str1.length(); i++){
            
            char ca = str1.charAt(i);
            char cb = str2.charAt(i);
            
            
            //aabcc, //cccdd
            //aabee            
            //bbbee
            //cccee
            //cccdd
            
            if(map.containsKey(ca)){
              
                 if(map.get(ca)!=cb){
                    return false;
                 }
                
            }else{
                
                // if(used.contains(cb)) return false;
                used.add(cb);
                map.put(ca, cb);
            }
        }
        
        return true;
        
    }
}