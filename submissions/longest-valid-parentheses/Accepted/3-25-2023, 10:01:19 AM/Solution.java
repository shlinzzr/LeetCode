// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        
        int res= 0;
        
        Stack<Integer> stk = new Stack();    
        stk.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.empty()) {
                    stk.push(i);
                } else {
                    ans = Math.max(ans, i - stk.peek());
                }
            }
        }
        return ans;
            
        
    }
}

// public class Solution {
//     public int longestValidParentheses(String s) {
//         LinkedList<Integer> stack = new LinkedList<>();
//         int result = 0;
//         stack.push(-1);
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
//                 stack.pop();
//                 result = Math.max(result, i - stack.peek());
//             } else {
//                 stack.push(i);
//             }
//         }
//         return result;
//     }
// }