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
          
          System.out.println(map[0]);
          
        int i=0;
        char a= 'a';
        for(char c : key.toCharArray()){
            if(c==' ')
                continue;
            
            if(map[c-'a']<'a' || map[c-'a']>'z'){
                map[c-'a'] = a;
                a++;    
            }
                
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()){
             if(c==' '){
                 sb.append(' ');
                continue;
             }
            sb.append(map[c-'a']);
        }
        
        return sb.toString();
        
    }
}