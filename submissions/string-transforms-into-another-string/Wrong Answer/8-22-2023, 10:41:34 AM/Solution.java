// https://leetcode.com/problems/string-transforms-into-another-string

class Solution {
    public boolean canConvert(String str1, String str2) {
        HashMap<Character, Character> map = new HashMap<>();
        
        int len = str1.length();
        HashSet<Character> freeze = new HashSet<>();
        for(int i=0; i<len; i++){
            
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if(map.containsKey(ch1)&&map.get(ch1)==ch2)
                continue;
            
            if(map.containsKey(ch1)&&map.get(ch1)!=ch2)
                return false;
            
            
            if(!map.containsKey(ch1)){
                map.put(ch1, ch2);
            }
            
        }
        
        return map.size()<26;
    }
}