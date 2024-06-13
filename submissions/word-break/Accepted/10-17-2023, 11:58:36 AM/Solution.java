// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set= new HashSet<>(wordDict);
        
        int len = s.length();

        StringBuilder sb = new StringBuilder(s);
        
        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        
        // for(int st=0; st<len; st++){
        //     for(int ed=st+1; ed<=len; ed++){

        for(int ed=1; ed<=len; ed++){
            for(int st=0; st<ed; st++){
                if(set.contains(sb.substring(st, ed)) && dp[st]){
                    dp[ed]=true;
                }
            }
        }

        return dp[len];


  // fail case : "aaa aaa a", dict=["aaaa", "aaa"]
        // int st= 0;
        // for(int ed=0; ed<=s.length(); ed++){
        //     String sub = s.substring(st, ed);
        //     if(set.contains(sub)){
        //         st=ed;
        //     }
        // }
        // return st==len;
      
    }
}