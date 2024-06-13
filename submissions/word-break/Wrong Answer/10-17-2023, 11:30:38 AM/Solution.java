// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set= new HashSet<>(wordDict);
        
        int len = s.length();
        
        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        
        // for(int st=0; st<len; st++){
        //     for(int ed=st+1; ed<=len; ed++){
        //         if(set.contains(s.substring(st, ed)) && dp[st]){
        //             dp[ed]=true;
        //         }
        //     }
        // }

        int st= 0;
        for(int ed=0; ed<=s.length(); ed++){
            String sub = s.substring(st, ed);
            if(set.contains(sub)){
                st=ed;
            }
        }
        
        return st==len;
    }
}