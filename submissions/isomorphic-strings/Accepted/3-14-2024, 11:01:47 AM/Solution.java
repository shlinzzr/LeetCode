// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        
        int len = s.length();
        for(int i=0; i<len; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if(!map.containsKey(a)){
                if(mapped.contains(b)) return false;
                map.put(a, b);
                mapped.add(b);
            }else{
                if(b!=map.get(a)) return false;
            }
        }
        
        return true;
            
        
    }
}