// https://leetcode.com/problems/unique-morse-code-words

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        
        String[] arr = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        for(String w : words){
            
            String str = "";
            char[] ca = w.toCharArray();
            for(char c : ca){
                str += arr[c-'a'];
            }
            
            set.add(str);
        }
        return set.size();
        
    }
}