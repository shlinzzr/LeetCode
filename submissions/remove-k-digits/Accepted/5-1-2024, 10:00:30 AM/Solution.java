// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();

        for(char ch : num.toCharArray()){


            while(k>0 && !st.isEmpty() && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(!st.isEmpty() && k-->0){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st){

            if(sb.isEmpty() && ch=='0') continue;
            sb.append(ch);
        }

        return sb.isEmpty()? "0" : sb.toString();
        
    }
}