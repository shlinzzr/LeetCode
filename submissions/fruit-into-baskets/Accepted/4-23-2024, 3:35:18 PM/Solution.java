// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        
        int len = fruits.length;
        int max = 0;
        
        if(len<2) return len;
        Map<Integer, Integer> map = new HashMap<>();
        
        
        int st=0 ;
        
        for(int ed=0; ed<len; ed++){
            
            int f = fruits[ed];
            map.put(f, map.getOrDefault(f,0)+1);
         
            while(map.size()>2){
                int ff = fruits[st];
                map.put(ff, map.get(ff)-1);
                if(map.get(ff)==0) map.remove(ff);
                st++;
            }
            
            
            max = Math.max(max, ed-st+1);
            
        }
        
        return max;
        
    }
}