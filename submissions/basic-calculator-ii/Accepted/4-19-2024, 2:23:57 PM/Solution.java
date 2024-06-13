// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {

        int val1=0; // init==0
        int op1=1; // 1 : add, -1:subtract
        int val2=1; // init==1
        int op2=1; // 1 : mul, -1 : div
        int len = s.length();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }

                val2 = op2==1? val2*num : val2/num;

            }else if(ch=='*' || ch =='/'){
                op2= ch=='*' ? 1 : -1;

            }else if(ch=='+' || ch =='-'){

                val1 += op1*val2;
                op1= ch=='+' ? 1 : -1;
                
                // clear lv2
                val2=1;
                op2=1;
            }
        }

        return val1 + op1*val2;
        
    }
}