// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int sign=1;
        int res = 0;
        int len = s.length();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num=num*10+(s.charAt(++i)-'0');
                }
                res+= num*sign;

            }else if(ch=='('){
                int j = i+1;
                int cnt =0 ;
                while(i<len){
                    if(s.charAt(i)=='(') cnt++;
                    if(s.charAt(i)==')') cnt--;
                    if(cnt==0) break;
                    i++;
                }

                int num = calculate(s.substring(j, i));
                res+= num*sign;
            }else if(ch=='+' || ch=='-'){
                sign=ch=='+' ? 1 : -1;
            }

        }

        return res;
    }
}