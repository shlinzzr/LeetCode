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
                    

                    if(map.get(sj).size()==0){
                        map.get(si).add(s.substring(j, i));
                    }else{
                        for(String prev : map.get(sj)){
                            map.get(si).add(prev + " "+ s.substring(j, i));
                        }
                    }

                    // System.out.println("si="+si +  " " + map.get(si));
                    // System.out.println("sj="+sj +  " " + map.get(sj));
                }
            }
        }
        
        return map.getOrDefault(s, new ArrayList<>());
        
    }
}