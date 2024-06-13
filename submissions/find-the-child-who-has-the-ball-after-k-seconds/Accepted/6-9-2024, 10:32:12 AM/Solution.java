// https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds

class Solution {
    public int numberOfChild(int n, int k) {
        
        
        int dir = -1;
        int idx= 0;
        while(k-->0){
            
            if(idx==0 || idx==n-1){
                dir = -dir;
            }
            
            idx+=dir;
            
            
            
        }
        
        return idx;
    }
}