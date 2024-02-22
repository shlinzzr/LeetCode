// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();//type, cnt
        
        int max =0 ;
        int st =0 ;
        for(int ed=0; ed<len; ed++){
            int f = fruits[ed];
            
            map.put(f, map.getOrDefault(f, 0)+1);
            while(map.size()>2){
                int fst = fruits[st];
                
                map.put(fst, map.get(fst)-1);
                if(map.get(fst)==0)
                    map.remove(fst);
                st++;
            }
            
            max = Math.max(max, ed-st+1);
        }
        
        return max;
        
    }
}