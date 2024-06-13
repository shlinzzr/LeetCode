// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] f) {
        
        int len = f.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max= 0 ;
        int st = 0;
        for(int ed=0; ed<len; ed++){
            
            map.put(f[ed], map.getOrDefault(f[ed], 0)+1);
            
            
            while(st<ed && map.size()>2){
                map.put(f[st], map.getOrDefault(f[st],0)-1);
                if(map.get(f[st])<=0)
                    map.remove(f[st]);
                st++;
            }
            
            int curr = 0;
            for(int cnt : map.values()){
                curr += cnt;
            }
            
            max = Math.max(max, curr);
            
        }
        
        return max;
        
    }
}