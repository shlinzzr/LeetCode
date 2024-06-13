// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {

        int val1=0, op1=1;
        int val2=1, op2=1;
        int res = 0 ;
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(ch==' ') continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                // System.out.println("num="+num);
                res+=op1*num;
            }else if(ch =='('){

                int j = i;
                for(int nest=0; j<s.length(); j++){
                    if(s.charAt(j)=='(') nest++;
                    if(s.charAt(j)==')') nest--;
                    if(nest==0) break;
                }   

                int num = calculate(s.substring(i+1, j));
                i=j;
                res += op1*num;
            }else{

                if(ch=='+'){
                    op1 = 1;
                }else
                    op1 = -1;


            }
        }
        // System.out.println(res);
        return res;

        
    }
}