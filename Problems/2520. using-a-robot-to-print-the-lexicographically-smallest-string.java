// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
    public String robotWithString(String s) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int[] freq = new int[26];
        for (char ch: s.toCharArray()){
            freq[ch -'a']++;
        }
        
        // cbazba =>    c b z b  ->    p : a a
        
        
        for (char ch: s.toCharArray()) {
            stack.push(ch);
            freq[ch - 'a']--; 
            while (!stack.isEmpty() && stack.peek() <= minChar(freq)) {
                sb.append(stack.pop());
            }    
        }
        
        while (stack.size() > 0) {
             sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    private char minChar(int[] freq) {
        for (int i = 0; i < 26; i++){
            if (freq[i] != 0) {
                return (char) ('a'+i);
            }
        } 
        return 'a'; 
    }
}