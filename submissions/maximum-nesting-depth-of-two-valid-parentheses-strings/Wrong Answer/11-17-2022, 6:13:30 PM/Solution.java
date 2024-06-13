// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Character> st = new Stack<>();
        
        int[] arr = new int[seq.length()];
        
        for(int i=0; i<seq.length(); i++){
            char ch = seq.charAt(i);
            
            int siz = st.size();
            
            if(ch=='('){
                st.push('(');
            }else {
                siz--;
                st.pop();
            }
            arr[i] = siz;
            
            
        }
        return arr;
        
    }
}