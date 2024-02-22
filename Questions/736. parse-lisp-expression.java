// https://leetcode.com/problems/parse-lisp-expression

class Solution {

// https://www.youtube.com/watch?v=XS6CXH2UORM

    public int evaluate(String expression) {
        return helper(expression, new HashMap<>());
    }

    private int helper(String exp, Map<String, Integer> map){
        
        if(isNum(exp))
            return Integer.valueOf(exp);

        if(isVar(exp))
            return map.get(exp);

        int res = 0;
        List<String> list = parse(exp);
        if("add".equals(list.get(0))){
            res = helper(list.get(1), map) + helper(list.get(2), map);

        }else if("mult".equals(list.get(0))){
            res = helper(list.get(1), map) * helper(list.get(2), map);

        }else {
            // let 
            HashMap<String, Integer> newMap = new HashMap<>(map);
            for(int i=1; i<list.size()-1; i+=2){
                newMap.put(list.get(i), helper(list.get(i+1), newMap));
            }

            res = helper(list.get(list.size()-1), newMap);
        }

        return res;
    }

    private List<String> parse(String exp){
        List<String> res = new ArrayList<>();
        exp = exp.substring(1, exp.length()-1);
        int startIndex = 0;
        
        while(startIndex<exp.length()){
            int endIndex = next( exp,  startIndex);
            res.add(exp.substring(startIndex, endIndex));
            startIndex = endIndex+1;
        }

        return res;
    }

    private int next(String exp, int idx){

        if(exp.charAt(idx)=='('){
            int cnt=1;
            idx++;

            while(idx<exp.length() && cnt>0){
                if(exp.charAt(idx)=='('){
                    cnt++;
                }else if(exp.charAt(idx)==')'){
                    cnt--;
                }
                idx++;
            }
        }else{
            while(idx<exp.length() && exp.charAt(idx)!=' '){
                idx++;
            }
        }

        return idx;

    }

    private boolean isNum(String exp){
        char ch = exp.charAt(0);
        return ch>='0' && ch<='9' || ch=='-';
    }

    private boolean isVar(String exp){
        char ch = exp.charAt(0);
        return ch>='a'&&ch<='z';
    }


        

}