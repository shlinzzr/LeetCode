// https://leetcode.com/problems/count-lattice-points-inside-a-circle

class Solution {
    public int countLatticePoints(int[][] circles) {
        int minX = 200;
        int minY = 200;
        int maxX = -200;
        int maxY = -200;
        
        
        for(int[] cir : circles){
            
            minX = Math.min(minX, cir[0]-cir[2]);
            maxX = Math.max(maxX, cir[0]+cir[2]);
            minY = Math.min(minY, cir[1]-cir[2]);
            maxY = Math.max(maxY, cir[1]+cir[2]);
        }
//         System.out.println(minX);
//         System.out.println(maxX);
//         System.out.println(minY);
//         System.out.println(maxY);
        
        
        int cnt=0;
        for(int i=minY; i<=maxY; i++){
            
            for(int j=minX; j<=maxX; j++){
                
                for(int[] cir: circles){
                    
                    int x = cir[0];
                    int y = cir[1];
                    int r = cir[2];
                    
                    // System.out.println(i + " " + j + " x=" + x + " y=" + y+ " r="+ r + " x^2="+((i-x)*(i-x)) +  " y^2="+((i-x)*(i-x)) + " res=" + ((i-x)*(i-x) + (i-y)*(i-y) <= r*r)); 
                    
                    
                    if((j-x)*(j-x) + (i-y)*(i-y) <= r*r){
                        cnt++;
                        break;
                    }
                }
            }
        }
        
        return cnt;
        
        
        
        
    }
}
