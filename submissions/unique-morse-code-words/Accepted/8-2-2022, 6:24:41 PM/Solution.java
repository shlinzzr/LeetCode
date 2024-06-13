// https://leetcode.com/problems/unique-morse-code-words

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        
        String[] arr = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        for(String w : words){
            
           StringBuilder sb = new StringBuilder();
            char[] ca = w.toCharArray();
            for(char c : ca){
                sb.append(arr[c-'a']);
            }
            
            set.add(sb.toString());
        }
        return set.size();
        
    }
}