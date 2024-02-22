// https://leetcode.com/problems/longest-string-chain

class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a,b)-> a.length()-b.length());        
        
        int len = words.length;
        
        HashMap<String, Integer>  map = new HashMap<>();
        
        int res = 0;
        
        for(String w : words){
            map.put(w, 1);
            
            for(int i=0; i<w.length();i++){
                
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if(map.containsKey(next)&&map.get(next)+1>map.get(w)){
                    map.put(w, map.get(next)+1);
                }
                
            }
            
            res = Math.max(res, map.get(w));
            
        }
        return res;
    }
}