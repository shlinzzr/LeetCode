// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> ist = new Stack<>();
        
        for(String token : tokens){
            
            if("+".equals(token)){
                int b = ist.pop();
                int a = ist.pop();
                ist.push(a+b);
                
            }else if("-".equals(token)){
                int b = ist.pop();
                int a = ist.pop();
                ist.push(a-b);
                
                
                
            }else if("*".equals(token)){
                int b = ist.pop();
                int a = ist.pop();
                ist.push(a*b);
                
                
            }else if("/".equals(token)){
                
                
                int b = ist.pop();
                int a = ist.pop();
                ist.push(a/b);
                
            }else{
                ist.push(Integer.valueOf(token));
            }
        }
        
        return ist.pop();
        
    }
}