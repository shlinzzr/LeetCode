// https://leetcode.com/problems/remove-invalid-parentheses

class Solution {
    
    int maxLen = 0;
    
    public List<String> removeInvalidParentheses(String s) {
        
        int st = 0;
        int remove =0;
        for(char ch : s.toCharArray()){
            
            if(ch=='(')
                st++;
            else if(ch==')')
                st--;
            
            if(st<0){
                remove++;
                st=0;
            }
        }
        
        remove+=st;
        maxLen = s.length()-remove;
        
        List<String> res = new ArrayList<>();
        dfs(s, 0, "", res, 0);
        return res;
    }
    
    private void dfs(String s, int i, String curr, List<String> res, int st){
        
        if(st<0) return;
        if(curr.length()>maxLen) return;
        if(i==s.length()){
            if(st==0 && curr.length()==maxLen){
                res.add(curr);
            }
            return;
        }
        
        if(s.charAt(i)!='(' && s.charAt(i)!=')')
            dfs(s, i+1, curr+s.substring(i, i+1), res, st);
        else{
            
            dfs(s, i+1, curr+s.substring(i, i+1), res, st+(s.charAt(i)=='('? 1: -1));
            if(curr.isEmpty() || s.charAt(i)!=curr.charAt(curr.length()-1))
                dfs(s, i+1, curr, res, st);
                
        }
    }
}