// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
      
        if(sx==fx && sy==fy )
            return t!=1;
        
        if(Math.abs(fx-sx)<=t  && Math.abs(fy-sy)<=t )
            return true;
        
        return false;
        
        
    }
}