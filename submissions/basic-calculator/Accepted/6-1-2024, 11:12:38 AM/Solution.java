// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {

        char op = '+';

        int len = s.length();
        Stack<Character> cst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        int cur = 0;

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }

                if(op=='+')
                    cur+= num;
                else
                    cur-=num;
                
            }else if(ch=='+' || ch=='-'){
                op = ch;
            }else if(ch=='('){
                cst.push(op);
                op='+';
                ist.push(cur);
                cur=0;
            }else if(ch==')'){
                op = cst.pop();
                if(op=='+'){
                    cur = ist.pop() + cur;
                }else{
                    cur = ist.pop()-cur;
                }
            }

        }

        return cur;
        
    }
}