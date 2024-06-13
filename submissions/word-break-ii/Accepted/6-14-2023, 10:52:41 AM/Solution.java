// https://leetcode.com/problems/word-break-ii

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        helper(s, 0, set, res, new ArrayList<>(), dp);
        return res;
    }
    
    
    private void helper(String s, int st, Set<String> set,  List<String> res, List<String> curr, boolean[] dp){
        
        if(st==s.length()){
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<curr.size(); i++){
                if(i!=0)
                    sb.append(" ");
                sb.append(curr.get(i));
            }
            res.add(sb.toString());
            return;
        }
            
        // for(int st = idx; st<s.length(); st++){
            
            for(int ed = st+1; ed<=s.length(); ed++){
                
                if(dp[st] && set.contains(s.substring(st, ed))){
                    dp[ed]=true;
                    curr.add(s.substring(st, ed));
                    helper(s, ed, set, res, curr, dp);
                    curr.remove(curr.size()-1);
                    dp[ed]=false;
                }
            }
        // }
        
       
        
        
        
        
    }
    
    
    
}