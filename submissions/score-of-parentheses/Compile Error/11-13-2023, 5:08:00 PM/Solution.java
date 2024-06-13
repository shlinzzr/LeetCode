// https://leetcode.com/problems/score-of-parentheses

class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length();
        
        if(len==0) 
            return 0;
        

        int first = s.indexOf("(")==-1;

        if(first==-1)
            return 0;
        
        int res = 0;

        int start = first, level = 0;
        for(int i=start; i<len; i++){

            char ch = s.charAt(i);
            if(ch=='(')
                level++;
            else 
                level--;

            if(level==0 && start==first){
                res = 2 * scoreOfParentheses(start+1, i);
            }


        }

        
    }
}