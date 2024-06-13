// https://leetcode.com/problems/expression-add-operators

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res= new ArrayList<>();

        int len = num.length();
        helper(res, 0, target, "", num, 0, 0);  
        // for(int i=1; i<=len; i++){
        //     long cur = Long.valueOf(num.substring(0, i));
        //     helper(res, cur, target, num.substring(0, i), num, i, cur);
        // }

        return res;
    }

    private void helper(List<String> res, long val, int target, String path, String num, int st, long prev){
        if(st==num.length()){
            if(val==target){
                res.add(path);
            }
            return;
        }

        
            
        for(int ed=st+1; ed<=num.length(); ed++){

            String sub = num.substring(st, ed);

            if(sub.length()>1 && sub.charAt(0)=='0')
                continue;

            long cur = Long.valueOf(sub);

            if(st==0){
                helper(res, cur, target, sub, num, ed, cur);

            }else{
                helper(res, val+cur, target, path+"+"+cur, num, ed, cur);
                helper(res, val-cur, target, path+"-"+cur, num, ed, -cur);
                helper(res, val-prev+prev*cur, target, path+"*"+cur, num, ed, cur*prev);
            }
        }
        
    }


}