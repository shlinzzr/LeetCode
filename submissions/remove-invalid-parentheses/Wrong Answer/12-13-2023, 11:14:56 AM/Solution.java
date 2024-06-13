// https://leetcode.com/problems/remove-invalid-parentheses

class Solution {
    public List<String> removeInvalidParentheses(String s) {
       

        int lv=0;
        int rm =0;
        for(char ch : s.toCharArray()){
            if(ch=='(')
                lv++;
            else if(ch==')'){
                if(lv==0)
                    rm++;
                else
                    lv--;
            }
        }
        rm += lv;

        int maxLen = s.length()-rm;

        List<String> res = new ArrayList<>();
        helper(s, 0, "", res, 0, maxLen);
        return res;

    }

    private void helper(String s, int idx, String curr,  List<String> res, int lv, int maxLen){
        
        if(lv<0) return ;
        
        if(curr.length()>maxLen) return;
            

        if(idx==s.length()){
            if(lv==0 && curr.length()==maxLen){
                res.add(curr);
            }
            return;
        }

        if(s.charAt(idx)!='(' && s.charAt(idx)!=')'){
            helper(s, idx+1, curr+s.substring(idx, idx+1), res, lv, maxLen);

        }else{

            lv += (s.charAt(idx)=='(' ? 1 : -1);
            helper(s, idx+1, curr+s.substring(idx, idx+1), res, lv, maxLen);
            if(curr.isEmpty() || s.charAt(idx)!=curr.charAt(curr.length()-1))
                helper(s, idx+1, curr, res, lv, maxLen);

        }
    }
}