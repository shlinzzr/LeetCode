// https://leetcode.com/problems/count-good-meals

class Solution {

    public int countPairs(int[] del) {
        int M = (int) 1e9+7;
        
        Map<Integer, Long> map = new HashMap<>();
        for(int d: del)
            map.put(d, map.getOrDefault(d, 0L)+1);
        
        long count = 0;
        
        Set<Integer> set = new HashSet<>();
        int cur=1;
        for(int i=0; i<=21; i++){
            set.add(cur);
            cur*=2;
        }
        
        
        
        for (int d: map.keySet()) {
            
            for (int p : set) {
                
                if (p-d==d) {
                    long val = map.get(p-d);
                    count += ((val-1) *val);
                }

                else if (map.containsKey(p-d))
                    count += map.get(d) * map.get(p-d);
            }
        }
        
        return (int) ((count / 2) % M);
    }

}