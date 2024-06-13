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

        String res = "";
        for(char ch : st){

            if(res.isEmpty() && ch=='0') continue;
            res+=ch;
        }

        return res.isEmpty()? "0" : res;
        
    }
}