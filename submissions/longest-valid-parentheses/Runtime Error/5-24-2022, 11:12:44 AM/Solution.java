// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack();
        
        String maxStr = "";
        
        String currStr = "";
        
        
        for(char c : s.toCharArray()){
            
           
            
            if( c=='('){
                stack.push(c);
                currStr+=c;
                
            }else{ // c==')'
                
                char ele = stack.pop();
                if(ele==')')
                    // valid
                    currStr+=c;
                else{
                    
                    if(currStr.length()> maxStr.length())
                        maxStr =  currStr;
                    currStr = "";
                }
                
            } 
        }
        
        if(currStr.length()> maxStr.length())
            maxStr =  currStr;
        
        
        return  maxStr.length();
            
        
    }
}