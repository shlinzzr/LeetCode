// https://leetcode.com/problems/cutting-ribbons

class Solution {
    public int maxLength(int[] ribbons, int k) {
        
        int max= 0 ;
        for(int r : ribbons)
            max = Math.max(r, max);
        
        int st =1, ed=max;
        
        while(st<ed){
            int mid = st + (ed-st+1)/2;
            
            if(getPieces(ribbons, mid)>=k)
                st = mid  ;
            else 
                ed = mid-1;
        }
        
        if(getPieces(ribbons, st)>=k)
            return st;
        else if(getPieces(ribbons, st-1)>=k)
            return st-1;
        
        
        return 0;
    }
    
    private int getPieces(int[] ribbons, int len){
        if(len==0)
            return 0;
        
        int cnt = 0;
        
        for(int r : ribbons){
            cnt += r/len;
        }
           // System.out.println("getP("+len +")= "+cnt);
        return cnt;
        
     
    }
}