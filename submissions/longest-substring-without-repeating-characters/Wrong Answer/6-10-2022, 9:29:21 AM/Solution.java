// https://leetcode.com/problems/longest-substring-without-repeating-characters

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
        
//         int max = 0;
//         for(int i=0; i<s.length(); i++){
            
//             HashSet<Character> set = new HashSet<>();
            
//             for(int j=i; j<s.length(); j++){
                
//                 if(set.contains(s.charAt(j))){
//                     break;
//                 }
                
//                 set.add(s.charAt(j));
                
//             }
            
//             if(set.size()>max)
//                 max = set.size();
            
            
//         }
        
//         return max;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0, j=0; i<s.length(); i++){
            
            if(map.containsKey(s.charAt(i))){
                j = map.get(s.charAt(i))+1;
            }
            
            map.put(s.charAt(i), i);
            
            int len = i-j+1;
            if(len > max)
                max = len;
                
        }
        
        return max;
    }
}