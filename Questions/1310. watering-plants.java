// https://leetcode.com/problems/watering-plants

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        boolean[] filled = new boolean[plants.length];
        
        int steps =0;
        int cur = capacity;
        
        while(filled[plants.length-1]==false){
            
            for(int i=0; i<plants.length; i++){
                
                if(filled[i]){
                    steps += 1;
                    continue;
                }
                    
                
                if(cur<plants[i]){
                    steps += i;
                    break;
                }
                
                steps += 1;
                cur -= plants[i];
                filled[i]=true;
            }
            
            
            
            cur = capacity;
        }
        
        return steps;
    }
}