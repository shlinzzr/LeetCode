// https://leetcode.com/problems/lemonade-change

class Solution {
    public boolean lemonadeChange(int[] bills) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        
        
        for(int b : bills){
            
            if(b==5)
                map.put(5, map.get(5)+1);
            
            else if(b==10){
                
                if(map.get(5)>0)
                    map.put(5, map.get(5)-1);
                else 
                    return false;
                
            }else if(b==20){
                
                if(map.get(10)>0 && map.get(5)>0){
                    map.put(10, map.get(10)-1);
                    map.put(5, map.get(5)-1);
                }else if(map.get(5)>0)
                    map.put(5, map.get(5)-3);
                else 
                    return false;
            }
        }
        
        return true;
    }
}