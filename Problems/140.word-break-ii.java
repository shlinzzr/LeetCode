// https://leetcode.com/problems/word-break-ii

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add("");

        Set<String> set = new HashSet<>(wordDict);

        TreeMap<Integer, List<String>> wLenMap = new TreeMap<>();
        for(String w: set){
            wLenMap.putIfAbsent(w.length(), new ArrayList<>());
            wLenMap.get(w.length()).add(w);
        }

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for(int i=1; i<=len; i++){  
            for(int wLen : wLenMap.keySet()){

                if(i-wLen<0) break;
                int j = i-wLen;

                String sub = s.substring(j, i);

                if(dp[j] && set.contains(sub)){
                    List<String> list = map.get(j);
                    map.putIfAbsent(i, new ArrayList<>());
                    for(String prev : list){
                        map.get(i).add( (prev.isEmpty() ? "" : (prev + " "))+ sub);
                    }
                    dp[i] = true;
                }
            }
        }

        return map.getOrDefault(len, new ArrayList<>());
        
    }
}