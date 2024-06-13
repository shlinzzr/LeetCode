// https://leetcode.com/problems/valid-anagram

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length())
//             return false;
        
//         for(int i=0; i<s.length(); i++){
            
//             char c = s.charAt(i);

//             int idx = t.indexOf(c);
            
//             if(idx<0){
//                 return false;
//             }
            
//             if(idx == t.length()-1)
//                 t = t.substring(0, idx);
//             else if(idx==0)
//                 t = t.substring(idx, t.length());
//             else
//                 t = t.substring(0, idx) + t.substring(idx+1, t.length());
//         }
        
//         return true;
//     }
// }

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}