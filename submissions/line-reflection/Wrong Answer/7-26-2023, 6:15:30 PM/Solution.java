// https://leetcode.com/problems/line-reflection

class Solution {
    public boolean isReflected(int[][] points) {
        int len = points.length;
        
        HashSet<String> negx = new HashSet<>();
        HashSet<String> negy = new HashSet<>();
        
        for(int i=0; i<len; i++){
            
            String key = points[i][0]+"_" + points[i][1];
            
            if(points[i][0]<0){
                negx.add(key);
            }
            
            if(points[i][1]<0){
                negy.add(key);
            }
        }
        
        
        
        boolean refx =true;
        boolean refy = true;
        
        for(int i=0; i<len; i++){
            
            String key = points[i][0]+"_" + points[i][1];
            
            if(points[i][0]>0){
                
                if(!negx.contains("-"+key))
                    refx=false;
            }
            
            if(points[i][1]>0){
                if(!negy.contains("-"+key))
                    refy=false;
            }
        }
        
        return refx || refy;
        
        
    
    }
}