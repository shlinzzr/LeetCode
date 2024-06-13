// https://leetcode.com/problems/score-of-parentheses

class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length();

        Stack<Integer> st = new Stack<>();

        int score = 0; 
        for(int i=0; i<len; i++){
            
            if(s.charAt(i)=='('){
                st.push(score);
                score=0;

            }else{
                score = st.pop() + Math.max(2*score, 1);
            }

        }

        return score;
        
    }
}