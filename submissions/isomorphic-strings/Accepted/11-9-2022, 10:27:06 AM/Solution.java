// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        int len = s.length();
        
        Set<Character> used = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<len; i++){
            
            if(!map.containsKey(s.charAt(i))){
                
                if(used.contains(t.charAt(i)))
                    return false;
                
                map.put(s.charAt(i), t.charAt(i));
                used.add(t.charAt(i));
            }else{
                
                if(map.get(s.charAt(i))!=t.charAt(i))
                     return false;
            }
        }
        
        return true;
        
    }
}