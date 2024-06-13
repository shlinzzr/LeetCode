// https://leetcode.com/problems/bulb-switcher

class Solution {
    public int bulbSwitch(int n) {
        boolean[] bool = new boolean[n];
        for(int cnt=1; cnt<=n; cnt++){
            
            
            for(int i=cnt-1; i<n; i+=cnt){
                
                bool[i]= !bool[i];
            }
        }
        
        int res = 0;
        for(int i=0; i<n; i++){
            if(bool[i])
                res++;
        }
        return res;
    }
}