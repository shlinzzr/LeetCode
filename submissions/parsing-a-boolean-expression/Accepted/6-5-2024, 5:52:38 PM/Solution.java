// https://leetcode.com/problems/parsing-a-boolean-expression

class Solution {
    public boolean parseBoolExpr(String exp) {

        List<Boolean> curr = new ArrayList<>();
        Stack<List<Boolean>> st = new Stack<>();
        Stack<Character> opst = new Stack<>();
        boolean res = false;

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch=='(' || ch==',') continue; //其實 !,&,| 才是開頭

            else if(ch=='!' || ch=='&' || ch=='|'){
                st.push(new ArrayList<>(curr));
                curr = new ArrayList<>();
                opst.push(ch);

            }else if(ch==')'){
                res = eval(opst.pop(), curr);
                curr = st.pop();
                curr.add(res);
            }else{
                curr.add(ch=='t');
            }
        }

        return res;
    }

    private boolean eval(char op, List<Boolean> list){

        boolean res = false;
        if(op=='!'){
            return !list.get(0);

        }else if(op=='&'){
            res = true;
            for(boolean b : list){
                res &=b;
            }

        }else if(op=='|'){
            res= false;
            for(boolean b: list){
                res |=b;
            }
        }

        return res;
    }
}