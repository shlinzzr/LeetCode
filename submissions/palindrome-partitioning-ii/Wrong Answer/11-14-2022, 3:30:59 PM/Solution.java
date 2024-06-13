// https://leetcode.com/problems/palindrome-partitioning-ii

class Solution {
    
    int min = Integer.MAX_VALUE;
    
    public int minCut(String s) {
        
        // dfs => TLE
        // => dp https://www.youtube.com/watch?v=o6znq56UGL8
        
        // List<List<String>> res = new ArrayList<>();
        int len = s.length();
        int[] dp = new int[len];
        
        dp[0] =1;
        
        for(int i=1; i<len; i++){
            
            for(int j=0; j<=i; j++){
                
                if(isPalindrome(s.substring(j, i))){
                    
                    if(j==0)
                        dp[i]=1;
                    else
                        dp[i] = Math.min(dp[i], dp[j-1]+1);    
                }
            }
            
        }
        
        
        return  dp[len-1];
        
        
        
        // helper(s, new ArrayList<>(), 0, len);
        // return min-1;
       
        
    }
    
    // dfs
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