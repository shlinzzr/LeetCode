// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
          int[][] res = new int[k][2];
        if(points.length==1){
                res[0][0] = points[0][0];
                res[0][1] = points[0][1];
            return res;            
        }
            
        
        
      
        
        int[] val = new int[points.length];
        for(int i=0; i<points.length; i++){
            
            val[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }
        
        
        for(int j=0;j<k; j++ ){
         
            int minidx = -1;
            int minVal = Integer.MAX_VALUE;
            for(int i=0; i<val.length-j; i++){
            
                if(i==0){
                    minidx=0;
                    minVal=val[i];
                    continue;
                }
                
                
                
                if(val[i]< minVal){
                    
                    int temp = val[i];
                    val[i] = minVal;
                    minVal = temp;
                    
                    
                    res[j][0] = points[i][0];
                    res[j][1] = points[i][1];
                    
                }
            
            }
            
            
            
        }
        
        return res;        
        
        
        
    }
}