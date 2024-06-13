// https://leetcode.com/problems/basic-calculator-iii

class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> ist = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            if(ch==' ') continue;
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                ist.push(num);
                
            }else if(ch=='('){
                ops.push(ch);
            }else if(ch==')'){
                
                while(ops.peek()!='('){
                    ist.push( operation(ops.pop(), ist.pop(), ist.pop()) );
                }
                ops.pop();
                
                
            }else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && precedence(ch, ops.peek())){
                     ist.push(operation(ops.pop(), ist.pop(), ist.pop()));
                }
                ops.push(ch);
            }
            
        }
        
        while(!ops.isEmpty()){
            ist.push( operation(ops.pop(), ist.pop(), ist.pop()) );
        }
        
        return ist.pop();
        
        
    }
    
    private boolean precedence(char op1, char op2){
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }
    
    
    private int operation(char op, int a, int b){
        
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        if(op=='*') return a*b;
        if(op=='/') return a/b;
        return 0;
    }
                              
                              
}