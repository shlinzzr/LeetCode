// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        
        for(int i=0; i<len; i++){
            
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            
            if(map.containsKey(chs) && map.get(chs)!=cht) return false;
            
            if(!map.containsKey(chs)){
                if(used.add(cht)==false) return false;
                map.put(chs, cht);
            }
        }
        
        return true;
    }
}