// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string

class Solution {
    public String removeDuplicates(String s) {
        
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
                continue;
                
            }else 
                st.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        
        
        return sb.toString();        
            
        
    }
}