// https://leetcode.com/problems/pass-the-pillow

class Solution {
    public int passThePillow(int n, int time) {
        
        
        time = time%(2*n-1);
        
        int dir = 1;
        int idx= 1 ;
        
        while(time>0){
            
            idx+=dir;
            
            if(idx==1 || idx==n)
                dir = -dir;
            
            time--;
        }
        
        return idx;
     
    }
}