// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        
//         String maxStr = "";
        
//         String currStr = "";
        int longest = 0, len = s.length();
        
        for(int i=0; i<s.length(); i++){
            // System.out.println("c="+c);
            char c = s.charAt(i);
            if( c=='(' ){
                stack.push(i);
                
            }else{ // c==')'
                if(!stack.isEmpty()){
                    
                    if(s.charAt(stack.peek())=='(')
                        stack.pop();
                    else 
                        stack.push(i);
                    
                    
//                      // System.out.println("ele="+ele);
//                     if(ele=='(' && (stack.isEmpty() || currStr.isEmpty()) ) // valid                        
//                         currStr+="()";
                    
//                     else{
//                         if(currStr.length()> maxStr.length())
//                             maxStr =  currStr;
//                         currStr = "";
//                     }
                 }
            }
            // System.out.println("currStr="+currStr);
        }
        

        if(stack.isEmpty())
            longest = len;
        else{
            int a = len, b =0;
            while(!stack.isEmpty()){
                
                b = stack.pop();
                longest = Math.max(longest, a-b-1);
                a=b;
                
            }
            
            longest = Math.max(longest, a);
        }
            
        
        
        
        
//         // if(!stack.isEmpty()){
//         //     currStr = currStr.substring(stack.size(), currStr.length());
//         // }
        
//           System.out.println("stack.size()="+stack.size());
        
// //           System.out.println("currStr="+currStr);
        
//         if(currStr.length()> maxStr.length())
//             maxStr =  currStr;
        
        
        return  longest;
            
        
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