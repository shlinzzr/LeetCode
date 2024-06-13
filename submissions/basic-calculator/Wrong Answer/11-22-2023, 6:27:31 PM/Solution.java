// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {

        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;
            
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
                
            if (Character.isDigit(c)) {
                int num = c - '0';
                    
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }
                
                l2 = (o2 == 1 ? l2 * num : l2 / num);
                    
            } else if (c == '(') {
                int j = i;
                    
                for (int cnt = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                
                int num = calculate(s.substring(j + 1, i));
                
                l2 = (o2 == 1 ? l2 * num : l2 / num);
                    
            } else if (c == '*' || c == '/') {
                o2 = (c == '*' ? 1 : -1);
                    
            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                l2 = 1; o2 = 1;
            }
        }
            
        return (l1 + o1 * l2);
    }
}