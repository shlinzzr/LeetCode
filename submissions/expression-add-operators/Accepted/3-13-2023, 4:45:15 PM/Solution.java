// https://leetcode.com/problems/expression-add-operators

class Solution {
    public List<String> addOperators(String s, int target) {
        List<String> res = new ArrayList<String>();
        
        if(s == null || s.length() == 0) 
            return res;
        
        helper(res, "", s, target, 0, 0, 0);
        
        return res;
    }
    
    public void helper(List<String> res, String path, String s, int target, int pos, long curr, long multed){
        if(pos == s.length()){
            if(target == curr)
                res.add(path);
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            if(i != pos && s.charAt(pos) == '0') 
                break;
            
            long num = Long.parseLong(s.substring(pos, i + 1));
            
            if(pos == 0){
                helper(res, path+num, s, target, i + 1, num, num);
            }
            
            else{
                helper(res, path + "+" + num, s, target, i + 1, curr+num , num);
                
                helper(res, path + "-" + num, s, target, i + 1, curr-num, -num);
                
                helper(res, path + "*" + num, s, target, i + 1, curr-multed + multed*num, multed*num );
            }
        }
    }
}