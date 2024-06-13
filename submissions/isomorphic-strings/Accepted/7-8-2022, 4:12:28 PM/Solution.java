// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> usedChar = new HashSet<>();
        
        for(int i=0; i<s.length();i++){
            
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            // System.out.println(cs + " " + ct);
            
            if( !map.containsKey(cs) && !usedChar.contains(ct) ){
                map.put(cs, ct);
                usedChar.add(ct);
                
            }else if(map.containsKey(cs) && map.get(cs)!=ct)
                    return false;
            else if(usedChar.contains(ct) && !map.containsKey(cs))
                return false;
                      
            
            
            
            
        }
        
        return true;
    }
}
