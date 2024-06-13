// https://leetcode.com/problems/maximize-the-minimum-powered-city

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int len = stations.length;
        long st =0, ed=Integer.MAX_VALUE;
        
        while(st<ed){
            
            long mid = ed- (ed-st)/2;
            
            if(isOK(stations, r, k , mid)){
                st = mid;
                
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
    }
    
    
    private boolean isOK(int[] stations, int r, int k, long mid){
        int len = stations.length;
        
        int win = 2*r;
        
        long curr = 0;
        
        int st=0;
        for(int ed=0; ed<len ; ed++){
            
            curr += stations[ed];
            
            if(ed!=len-1 && ed-st<win)
                continue;
            
            if(ed-st>win){
                curr-= stations[st];
                st++;
            }
                
            if(curr>=mid)
                continue;
            
            if(k>0 && curr+k >= mid){
                k -= mid-curr;
                continue;
            }
            
            if(curr<mid)
                return false;
        }
        
        return true;
        
        
        
    }
    
}