// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if(map.containsKey(cs)){
                char ca = map.get(cs);
                if(ca!=ct)
                    return false;
            }else{
                map.put(cs, ct);
            }
        }
        
        return true;
    }
}