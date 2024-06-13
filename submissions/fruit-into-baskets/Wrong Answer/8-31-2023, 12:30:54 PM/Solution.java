// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        
        
        HashMap<Integer, Integer> cnt = new HashMap<>(); // type, idx;
        HashMap<Integer, Integer> map = new HashMap<>(); // type, idx;
        
        int len = fruits.length;
        int max = 0;
        for(int i=0; i<len; i++){
            
            int f = fruits[i];
            
            if(map.size()<2 || map.containsKey(f)){
                
                if(!map.containsKey(f)){
                    map.put(f, i);
                }
                
                cnt.put(f, cnt.getOrDefault(f, 0)+1);
                
                int val = 0;
                for(int k: cnt.keySet()){
                    val += cnt.get(k);
                }
                max = Math.max(max, val);
            }else{
                int rm_type = -1;
                int min = Integer.MAX_VALUE;
                int val = 0;
                
                for(int k : map.keySet()){
                    
                    int v = cnt.get(k);
                    int idx = map.get(k);
                    
                    
                    val += v;                    
                    if(idx<min){
                        min = idx;
                        rm_type=k;
                    }
                }
                
                
                max = Math.max(max, val);
                
                map.remove(rm_type);
                cnt.remove(rm_type);
                map.put(f, i);
                cnt.put(f, 1);
            }
            
            // System.out.println(map.keySet() + " " + map.values());
        }
        
        int res = 0;
        
        
        
        return max;
    }
}