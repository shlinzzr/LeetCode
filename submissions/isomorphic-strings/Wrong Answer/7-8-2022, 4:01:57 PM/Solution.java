// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        Map<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<s.length()-1;i++){
            
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if( !map.containsKey(cs) )
                map.put(cs, ct);
            else
                if(map.get(cs)!=ct)
                    return false;
            
            
            
            
            
        }
        
        return true;
    }
}
