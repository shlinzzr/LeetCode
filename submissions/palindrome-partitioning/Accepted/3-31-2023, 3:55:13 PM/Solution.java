// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        helper(s, new ArrayList<>(), res, 0, s.length());
        
        return res;
    }
    
    private void helper(String s, List<String> curr, List<List<String>> res, int idx, int len){
        
        if(idx==len){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=1; i<=s.length(); i++){
            
            String prefix = s.substring(0, i);
            
            if(isPal(prefix)){
                curr.add(prefix);
                helper(s.substring(i), curr, res, idx+i, len);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    private boolean isPal(String s){
        int st=0, ed=s.length()-1;
        while(st<ed){
            if(s.charAt(st)!=s.charAt(ed))
                return false;
            st++;
            ed--;
        }
        
        return true;
    }
}