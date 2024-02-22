// https://leetcode.com/problems/pass-the-pillow

class Solution {
    public int passThePillow(int n, int time) {
        
        int slot = n+n-2;
        time = time%slot;
        int fac = 1;
        
        int idx=1;
        
        while(time>0){
            
            idx+=fac;
            if(idx==n){
                fac=-1;
            }else if(idx==1){
                fac=1;
            }
            
            time--;            
        }
        
        
        return idx;
    }
}