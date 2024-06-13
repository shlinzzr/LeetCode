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

        //剪枝
        if(lv<0) return ;
        if(curr.length()>maxLen)return;

        //終止條件
        if(idx==s.length()){
            if(lv==0 && curr.length()==maxLen){
                res.add(curr);
            }
            return;
        }

        // a-z 直接取
        if(s.charAt(idx)!='(' && s.charAt(idx)!=')'){
            helper(s, idx+1, curr+s.substring(idx, idx+1), res, lv, maxLen);

        }else{

            //最後一個字元不相等 : 可取可不取             
            //最後一個字元相等 : 只能取
            helper(s, idx+1, curr+s.substring(idx, idx+1), res, lv+(s.charAt(idx)=='(' ? 1 : -1), maxLen);
            if(curr.isEmpty() || s.charAt(idx)!=curr.charAt(curr.length()-1))
                helper(s, idx+1, curr, res, lv, maxLen);
        }
       
    }
}