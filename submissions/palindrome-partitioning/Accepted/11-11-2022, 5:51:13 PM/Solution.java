// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        int len = s.length();
        
        helper(s, res, new ArrayList<>(), 0, len);
        
        return res;
       
        
    }
    
    
    private void helper(String s, List<List<String>> res, List<String> curr, int cnt, int len){
        
        if(cnt==len){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        
        for(int i=1; i<=s.length(); i++){
            String prefix = s.substring(0, i);
            
            // System.out.println(prefix);
            
            if(isPalindrome(prefix)){
                curr.add(prefix);
                helper(s.substring(i), res , curr, cnt+i, len);
                curr.remove(curr.size()-1);    
            }
        }
    }
    
    
    private boolean isPalindrome(String s){
        
        int len = s.length();
        for(int i=0; i<len/2; i++){
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        }
        
        return true;
        
    }
    
}