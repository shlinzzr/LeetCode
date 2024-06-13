// https://leetcode.com/problems/maximize-distance-to-closest-person

class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int len = seats.length;
        int cnt =0;
        int idx =0;
        int abs= 0;
        boolean stcnt=false;
        
        for(int i=0; i<len; i++){
            if(seats[i]==0)
                seats[i]=1;
            else
                seats[i]=0;
            
            int s = seats[i];
            
            if(s==0){
                cnt=0;
                stcnt=true;
               
            }else if(stcnt){
                cnt++;
            }
                
            
            if(cnt>abs){
                abs=cnt;
                idx = i;
            }
        }
        
        int rabs = abs;
        int ridx = idx;
        stcnt =false;
        cnt=0;
        abs=0;
        for(int i=len-1; i>=0; i--){
            int s = seats[i];
            
            if(s==0){
                cnt=0;
                stcnt=true;
            }else if(stcnt){
                cnt++;
            }
                
            
            if(cnt>abs){
                abs=cnt;
                idx = i;
            }
        }
        
        int res = (idx + ridx)/2;
        
        
        return res;
        
        
        
        
    }
}