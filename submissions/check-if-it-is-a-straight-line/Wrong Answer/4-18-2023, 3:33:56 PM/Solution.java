// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coord) {
        int len = coord.length;
        
        if(len==2)
            return true;
        
        int y = (coord[1][1]-coord[0][1]);
        
        int r = y==0 ? 0 : (coord[1][0]-coord[0][0]) / y;
        
        
        for(int i=2; i<len ;i++){
            
            int yy = (coord[i][1]-coord[0][1]);
            if(y==0){
                
                if(yy!=0)
                    return false;
            }else{
                int rr = (coord[i][0]-coord[0][0]) / yy;
                if(rr!=r)
                    return false;
                
            }
            
        }
        return true;
    }
}