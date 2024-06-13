// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        s = s.trim();
        
        int len = s.length();
        
        
        Stack<Integer> ist = new Stack<>();
        Stack<Character> ost = new Stack<>();
        char op='+';
        int num = 0;

        
        
        for(int i=0; i<len ; i++){
            
            char ch = s.charAt(i);
            
            if(ch ==' ')
                continue;
            
            if(Character.isDigit(ch)){
                
                num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                
                // ist.push(num);
                
            }
            
            if(s.charAt(i)!=' ' || i==len-1){
                
                if(op=='+'){
                    ist.push(num);
                    
                }else if(op=='-')
                    ist.push(-num);
                    
                else if(op=='*'){
                    ist.push(ist.pop()*num);
                    
                }else if(op=='/'){
                    ist.push(ist.pop()/num);
                }
                op=ch;
                num=0;
            }
        }
        
        int total = 0;
        
        for(int i : ist){
            total+=i;
        }
        
        return total;
        
        
        
    }
}