// https://leetcode.com/problems/maximize-win-from-two-segments

class Solution {
    public int maximizeWin(int[] P, int k) {
        int len = P.length;

        boolean first=false;
        boolean sec = false;
        
        
        int cnt = 0;
        
        for(int i=len-1; i>=k; i--){
            
            if(first==false)
                first=true;
            else if(sec==false)
                sec=true;
            else 
                break;
            
            
            int ed = P[i]; 
            int st = P[i-k];
            
            
            // System.out.println(st + " " + ed);
            
            while(i>=0 && P[i]>=st && P[i]<=ed ){
                
                // System.out.println(i);
                
                i--;
                cnt++;
            }
            i++;
        }
        
        return cnt;
    }
}