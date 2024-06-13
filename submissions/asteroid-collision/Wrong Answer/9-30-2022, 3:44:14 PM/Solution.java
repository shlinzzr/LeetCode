// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int leftMax=0, rightMin= 0;
        int leftIdx=0, rightIdx=asteroids.length;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<asteroids.length; i++){
            int cur =  asteroids[i];
            
            if(cur<0){
                
                if(Math.abs(cur)<leftMax){
                    //pass
                }else{
                    
                    for(int j=0; j<list.size()-leftIdx; j++){
                        list.remove(leftIdx);
                    }
                    leftMax=0;
                    leftIdx=0;
                }
                
                rightMin = Math.min(rightMin, cur);
                rightIdx = i;
                
            }else{
                list.add(cur);
                leftMax = Math.max(leftMax, cur);
                leftIdx = i;
            }
        }
        
        leftMax=0;
        rightMin= 0;
        
        for(int i=list.size()-1; i>=0; i--){
            int cur =  list.get(i);
            
            if(cur>=0){
                if(cur<Math.abs(rightMin)){
                    //pass
                }else{
                    
                    for(int j=0; j<list.size()-rightIdx; j++){
                        list.remove(rightIdx);
                    }
                    rightMin= 0;
                    rightIdx=asteroids.length;
                }
                
                leftMax = Math.max(leftMax, cur);
            }else{
                list.add(cur);
                rightMin = Math.min(rightMin, cur);
            }
        }
        
        for(int i: list){
            System.out.print(i + ", ");
        }
        
        return new int[0];
        
        
    }
}