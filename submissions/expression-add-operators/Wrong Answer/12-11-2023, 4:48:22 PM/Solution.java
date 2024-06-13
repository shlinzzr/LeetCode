// https://leetcode.com/problems/expression-add-operators

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res= new ArrayList<>();

        int len = num.length();
        
        for(int i=1; i<=len; i++){
            long cur = Long.valueOf(num.substring(0, i));
            helper(res, cur, target, num.substring(0, i), num, i, cur);
        }

        return res;
    }

    private void helper(List<String> res, long val, int target, String path, String num, int st, long prev){
        if(st==num.length()){
            if(val==target){
                res.add(path);
            }
            return;
        }

        
            
        for(int i=st+1; i<=num.length(); i++){

            String sub = num.substring(st, i);

            if(sub.length()>1 && sub.charAt(0)=='0')
                continue;

            long cur = Integer.valueOf(sub);

            helper(res, val+cur, target, path+"+"+cur, num, i, cur);
            helper(res, val-cur, target, path+"-"+cur, num, i, -cur);
            helper(res, val-prev+prev*cur, target, path+"*"+cur, num, i, cur*prev);
        }
        
    }


}