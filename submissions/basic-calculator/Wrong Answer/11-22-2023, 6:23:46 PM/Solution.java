// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {

        int lv1 = 0, op1 = 1; //  lv1 value init:0       op1=> 1:pos(+), -1:neg(-)
        int lv2 = 1, op2 = 1; //  lv2 value init:1       op2=> 1:pos(*), -1:neg(/)
            
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
                
            if (Character.isDigit(ch)) {
                int num = ch-'0';
                    
                while (i+1< s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }
                
                // evaluate at level two:
                lv2 = (op2==1 ? lv2*num : lv2/num);
                    
            } else if (ch == '(') {
                int j = i;
                    
                for (int cnt = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                
                int num = calculate(s.substring(j + 1, i));

                 // evaluate at level two:
                lv2 = (op2==1 ? lv2*num : lv2/num);
                    
            } else if (ch=='*' || ch=='/') {
                op2 = (ch=='*' ? 1 : -1);
                    
            } else if (ch == '+' || ch == '-') {

                // only evaluate level one when meet lv1:
                lv1 += op1 * lv2;
                op1 = (ch=='+' ? 1 : -1);

                // reset lv2
                lv2 = 1; op2 = 1;
            }
        }
        // we have lv1 & lv2 now, merge them using lv1 formula
        return (lv1 + op1 * lv2);
    }
}