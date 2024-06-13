// https://leetcode.com/problems/parsing-a-boolean-expression

class Solution {
    public boolean parseBoolExpr(String ex) {
        Stack<Character> op = new Stack<>();
        Stack<List<Boolean>> st = new Stack<>();
        List<Boolean> curr = new ArrayList<>();

        boolean res = false;

        for (int i=0; i<ex.length(); i++){
            char ch = ex.charAt(i);

            System.out.println("ch="+ch + " curr=" + curr);
            if( ch=='!' || ch=='&' || ch=='|'){
                op.push(ch);
                st.push(curr);
                curr.clear();
                i++;

            } else if (ch==')') {

                //  ret = eval(stackOp.top(), curVals);
                // stackOp.pop();
                // curVals = stackVal.top();
                // curVals.push_back(ret);
                // stackVal.pop();


                res = eval(op.peek(), curr);
                op.pop();
                curr.clear();
                curr = st.peek();
                curr.add(res);
                st.pop();
                
            }
            else if (ch=='t' || ch=='f' ) {
                curr.add(ch=='t');
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
                result = result && list.get(i);

        } else if (op=='|')  {
            result = false;
             for (int i=0; i<list.size(); i++)
                result = result || list.get(i);
        }
        System.out.println("eval="+result);
        return result;
    }
}