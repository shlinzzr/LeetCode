// https://leetcode.com/problems/different-ways-to-add-parentheses

class Solution {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String exp) {

        // if(memo.containsKey(exp)) return memo.get(exp);

        List<Integer> res = new ArrayList<>();
        int len = exp.length();

        boolean digitOnly = true;

        for(int i=0; i<len; i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)) continue;

            digitOnly = false;
            String pre = exp.substring(0, i);
            String suf = exp.substring(i+1, len);

            List<Integer> lista = diffWaysToCompute(pre);
            List<Integer> listb = diffWaysToCompute(suf);
            for(int a: lista){
                for(int b : listb){

                    if(ch=='+')  res.add(a+b);
                    else if(ch=='-') res.add(a-b);
                    else if(ch=='*') res.add(a*b);
                    else if(ch=='/') res.add(a/b);
                }
            }
        }

        if(digitOnly) res.add(Integer.parseInt(exp));

        memo.put(exp, res);

        return res;
        
    }
}