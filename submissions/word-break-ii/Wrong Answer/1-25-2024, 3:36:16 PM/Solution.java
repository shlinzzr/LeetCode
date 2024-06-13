// https://leetcode.com/problems/word-break-ii

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>(wordDict);
        
        int len = s.length();
        
        List<String> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=1; i<=len ;i++){
            
            for(int j=0; j<i; j++){
                
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    
                    String si = s.substring(0, i);
                    String sj = s.substring(0, j);
                    map.putIfAbsent(si, new ArrayList<>());
                    map.putIfAbsent(sj, new ArrayList<>());
                    
                    for(String sub : map.get(sj)){
                        map.get(si).add(sub + " "+ s.substring(j, i));
                    }    
                }
            }
        }
        
        return map.getOrDefault(s, new ArrayList<>());
        
    }
}