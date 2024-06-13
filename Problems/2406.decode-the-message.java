// https://leetcode.com/problems/decode-the-message

class Solution {
//     public String decodeMessage(String key, String message) {
//         Map<Character, Character> map = new HashMap<>();
//         map.put(' ', ' ');
//         char a = 'a';
//         for(char c : key.toCharArray()){
            
//             if(!map.containsKey(c) && c!=' '){
//                 map.put(c, a);
//                 a++;    
//             }
//         }
        
//         StringBuilder sb = new StringBuilder();
//         for(char c : message.toCharArray()){
//             sb.append(map.get(c));
//         }
        
//         return sb.toString();
        
//     }
    
      public String decodeMessage(String key, String message) {
        char[] map = new char[26];
          
          
        char a= 'a';
        for(char c : key.toCharArray()){
            if(c==' ')
                continue;
            
            if(map[c-'a']<'a' || map[c-'a']>'z'){
                map[c-'a'] = a;
                a++;    
            }
                
        }
        
        char[] result = message.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == ' ') continue;
            result[i] = map[result[i] - 'a'];
        }
        return new String(result);
        
        
    }
}