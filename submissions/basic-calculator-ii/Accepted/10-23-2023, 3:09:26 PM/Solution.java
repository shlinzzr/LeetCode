// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        s = s.trim();
        
        int len = s.length();
        
        
        Stack<Integer> ist = new Stack<>();
        Stack<Character> ost = new Stack<>();
        char op='+';
        
        for(int i=0; i<len ; i++){
            char ch = s.charAt(i);
            if(ch ==' ')
                continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    i++;
                    num = num*10 + (s.charAt(i)-'0');
                }
                if(op=='+'){
                    ist.push(num);
                    
                }else if(op=='-')
                    ist.push(-num);
                    
                else if(op=='*'){
                    ist.push(ist.pop()*num);
                    
                }else if(op=='/'){
                    ist.push(ist.pop()/num);
                }

            }else {
                op=ch;
            }

        }
        
        int total = 0;
        
        for(int i : ist){
            total+=i;
        }
        
        return total;
        
        
        
    }
}