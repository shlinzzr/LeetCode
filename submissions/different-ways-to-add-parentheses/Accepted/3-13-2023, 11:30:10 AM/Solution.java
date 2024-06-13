// https://leetcode.com/problems/different-ways-to-add-parentheses

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            
            if(ch=='-' || ch=='+' || ch=='*'){
                
                List<Integer> p1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> p2 = diffWaysToCompute(expression.substring(i+1, expression.length()));
                
                for(int i1: p1){
                    for(int i2: p2){
                        
                        int c =0;
                        switch(ch){
                            case '+':
                                c=i1+i2;
                                break;
                            case '-':
                                c=i1-i2;
                                break;
                            case '*' :
                                c=i1*i2;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.size()==0){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}