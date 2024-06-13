// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
    public String robotWithString(String s) {
        
        int len = s.length();
        
        char[] nextSmallest = new char[len];
        Arrays.fill(nextSmallest, Character.MAX_VALUE);
        
        char min = 'z'+1;        
        for (int i=len-1; i>=0; i--){
            
            if(s.charAt(i)<min){
                min = s.charAt(i);
            }
            nextSmallest[i] = min;
            
        }
                
        Stack<Character> st = new Stack<>();
        String ret="";
        int i = 0;
        while (i<len){
            
            if (st.isEmpty() || nextSmallest[i] < st.peek()){
                st.push(s.charAt(i));                
                i++;
                
            } else {
                
                
                ret += st.pop();                
            }            
        }
        
        while (!st.isEmpty())
        {
            ret += st.pop();
        }
        
        return ret;
    }
    
    
}