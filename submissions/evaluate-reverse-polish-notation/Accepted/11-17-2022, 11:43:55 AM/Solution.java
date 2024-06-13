// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        
        List<String> list = Arrays.asList("+", "-", "*", "/");
        
        Stack<String> st = new Stack<>();
        
        
        for(String s : tokens){
            
            if(list.contains(s)){
                
                int n1 = Integer.valueOf(st.pop());
                int n2 = Integer.valueOf(st.pop());
                int res = 0;
                switch(s){
                    case "+":
                        res = n2+n1;
                        break;
                    case "-":
                        res = n2-n1;
                        break;    
                    case "*":
                        res = n2*n1;
                        break;
                        
                    case "/":
                        res = n2/n1;
                        break;
                }
                
                st.push(String.valueOf(res));
            }else{
                st.push(s);
            }
        }
        
        return Integer.valueOf(st.pop());
        
        
        
    }
}