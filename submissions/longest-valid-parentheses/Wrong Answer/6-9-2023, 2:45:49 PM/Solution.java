// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
         int left = 0;
        int cnt = 0;
        int max = 0;
        for(char ch : s.toCharArray()){
            
            if(ch=='('){
                left++;
            }else{
                
                if(left>0){
                    cnt+=2;
                    left--;
                }
                    
                else
                   cnt=0;
            }
            
            // System.out.println(cnt);
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}