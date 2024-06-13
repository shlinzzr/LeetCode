// https://leetcode.com/problems/palindrome-partitioning-ii

class Solution {
    
    int min = Integer.MAX_VALUE;
    
    public int minCut(String s) {
        // List<List<String>> res = new ArrayList<>();
        
        int len = s.length();
        
        helper(s, new ArrayList<>(), 0, len);
        
        return min-1;
       
        
    }
    
    
    private void helper(String s,  List<String> curr, int cnt, int len){
        
        if(curr.size()>min)
            return;
        
        if(cnt==len){
            // res.add(new ArrayList<>(curr));
            min = Math.min(min, curr.size());
            return;
        }
        
        
        for(int i=s.length(); i>0; i--){
            String prefix = s.substring(0, i);
            
            // System.out.println(prefix);
            
            if(isPalindrome(prefix)){
                curr.add(prefix);
                helper(s.substring(i),  curr, cnt+i, len);
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