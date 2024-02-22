// https://leetcode.com/problems/unique-morse-code-words

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for(String w : words){
            
            String s = "";
            for(char c : w.toCharArray()){
                s+= arr[c-'a'];
            }
            
            if(!set.contains(s)){
                set.add(s);
            }
            
        }
        
        return set.size();
    }
}