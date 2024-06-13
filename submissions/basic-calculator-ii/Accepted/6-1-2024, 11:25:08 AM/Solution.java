// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {

        char op1 = '+', op2='*';


        int len = s.length();
        Stack<Character> cst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        long cur1 = 0, cur2=1;

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }

                if(op2=='*'){
                    cur2 *= num;
                }else 
                    cur2/=num;

            }else if(ch=='+' || ch=='-'){

                if(op1=='+'){
                    cur1+=cur2;
                }else
                    cur1-=cur2;

                cur2=1;
                op2='*';

                op1 = ch;

            }else if(ch=='*' || ch=='/'){
                op2 = ch;

            }else if(ch=='('){

                int j=i;
                for(int lv=0; j<len; j++){
                    if(s.charAt('j')=='(') lv++;
                    if(s.charAt('j')==')') lv--;
                    if(lv==0) break;
                }

                String sub = s.substring(i+1, j);
                int rt = calculate(sub);

                if(op2=='*'){
                    cur2 *= rt;
                }else{
                    cur2 /= rt;
                }
            }
            // }else if(ch==')'){
            //     op = cst.pop();
            //     if(op=='+'){
            //         cur = ist.pop() + cur;
            //     }else{
            //         cur = ist.pop()-cur;
            //     }
            // }

        }

        if(op1=='+'){
            cur1 += cur2;
        }else{
            cur1 -= cur2;
        }

        return (int)cur1;
 
        
    }
}