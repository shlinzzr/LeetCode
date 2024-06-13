// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        
        List<String> list = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        
        
        for(String s : tokens){
            
            if(list.contains(s)){
                int n1 = Integer.valueOf(st.pop());
                int n2 = Integer.valueOf(st.pop());
                int res = 0;
                
                switch(s){
                    case "+":
                        res = n1+n2;
                        break;
                        
                    case "-":
                        res = n1-n2;
                        break;
                    case "*":
                        res = n1*n2;
                        break;
                        
                    case "/":
                        res = n1/n2;
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