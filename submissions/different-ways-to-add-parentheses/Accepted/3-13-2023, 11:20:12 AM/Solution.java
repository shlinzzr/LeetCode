// https://leetcode.com/problems/different-ways-to-add-parentheses

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        
        return res;
    }
    
    
//     private int cal(String s){
//         int res =0;
//         int sign=1;
//         int len = s.length();
        
//         Stack<Integer> st = new Stack<>();
        
//         for(int i=0; i<len; i++){
//             char ch = s.charAt(i);
            
//             if(ch==' ')
//                 continue;
//             else if(Character.isDigit(ch)){
//                 int num = ch-'0';
//                 while(i+1<len && Character.isDigit(s.charAt(i+1))){
//                     num = num*10 + (s.charAt(i+1)-'0');
//                     i++;
//                 }
//                 res += num*sign;
//             }else if(ch=='+')
//                 sign=1;
//             else if(ch=='-')
//                 sign=-1;
//             else if(ch=='('){
//                 st.push(res);
//                 st.push(sign);
//                 res=0;
//                 sign=1;
//             }else if(ch==')'){
//                 res = st.pop()*res + st.pop();
//             }
//         }
        
//         return res;
        
        
//     }
    
}