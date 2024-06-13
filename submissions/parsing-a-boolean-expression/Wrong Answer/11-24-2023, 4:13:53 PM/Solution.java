// https://leetcode.com/problems/parsing-a-boolean-expression

class Solution {
    public boolean parseBoolExpr(String ex) {
        Stack<Character> op = new Stack<>();
        Stack<List<Boolean>> st= new Stack<>();
        List<Boolean> curr = new ArrayList<>();

        boolean res = false;

        for (int i=0; i<ex.length(); i++){
            char ch = ex.charAt(i);
            if( ch=='!' || ch=='&' || ch=='|'){
                op.push(ex.charAt(i));
                st.push(curr);
                curr.clear();
                i++;

            } else if (ch==')') {

                res = eval(op.pop(), curr);
                curr = st.pop();
                curr.add(res);
                
            }
            else if (ex.charAt(i)=='t' || ex.charAt(i)=='f' ) {
                curr.add(ex.charAt(i)=='t');
            }
        }

        return res;
    }

    private boolean eval(char op, List<Boolean> list){
        boolean result=false;
        if (op=='!')
            result = !list.get(0);

        else if (op=='&'){
            result = true;
            for (int i=0; i<list.size(); i++)
                result &= list.get(i);

        } else if (op=='|')  {
            result = false;
             for (int i=0; i<list.size(); i++)
                result |= list.get(i);
        }

        return result;
    }
}