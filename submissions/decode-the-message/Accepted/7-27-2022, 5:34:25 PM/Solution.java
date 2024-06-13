// https://leetcode.com/problems/decode-the-message

class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        char a = 'a';
        for(char c : key.toCharArray()){
            
            if(!map.containsKey(c) && c!=' '){
                map.put(c, a);
                a++;    
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()){
            sb.append(map.get(c));
        }
        
        return sb.toString();
        
    }
}