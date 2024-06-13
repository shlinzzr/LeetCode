// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special

class Solution {
    public int minimumDeletions(String word, int abs) {
        
        HashMap<Character, Integer> map= new HashMap<>();
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        TreeMap<Integer, Integer> f = new TreeMap<>(); // freq , 有幾個數字
        for(int v : map.values()){
            f.put(v, f.getOrDefault(v,0)+1);
        }
        
        int res = word.length();
        
        for(int i = f.firstKey(); i<=f.lastKey(); i++){
            
            int cur = 0;
            for(int k : f.keySet()){
                if(k<i){
                      cur += (k*f.get(k));
                }
                if(k-i>abs){
                    cur += Math.min(f.get(k)*k , (k-i-abs)*f.get(k));
                }
            }
            res = Math.min(res, cur);
        }
       
        return res;
       
        
    }
}