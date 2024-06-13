// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {

        int lv1=0, op1=1;
        int lv2=1, op2=1;
        int len = s.length();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ')
                continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(++i)-'0');
                }

                lv2 = op2==1? lv2*num : lv2/num;
            }else if(ch=='*' || ch =='/'){

                op2= ch=='*' ? 1 : -1;

            }else if(ch=='+' || ch =='-'){

                lv1 += op1*lv2;
                op1= ch=='+' ? 1 : -1;
                lv2=1;
                op2=1;
            }
        }

        return lv1 + op1*lv2;
        
    }
}