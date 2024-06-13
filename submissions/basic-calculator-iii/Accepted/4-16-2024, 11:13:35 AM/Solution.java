// https://leetcode.com/problems/basic-calculator-iii

class Solution {
    public int calculate(String s) {

        int lv1=0, op1=1;
        int lv2=1, op2=1;
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

                lv2 = op2==1? lv2*num : lv2/num;
            }else if(ch=='('){

                int j = i;
                for(int cnt=0; j<len; j++){
                    if(s.charAt(j)=='(') cnt++;
                    if(s.charAt(j)==')') cnt--;
                    if(cnt==0) break;
                }
                int num = calculate(s.substring(i+1, j));
                lv2 = op2==1? lv2*num : lv2/num;
                i=j;

            }else if(ch=='*' || ch =='/'){

                op2= ch=='*' ? 1 : -1;

            }else if(ch=='+' || ch =='-'){
                
                // send val2 to val1
                lv1 += op1*lv2;
                op1= ch=='+' ? 1 : -1;

                //reset val2, op2
                lv2=1;
                op2=1;
            }
        }

        return lv1 + op1*lv2;
        
    }
}