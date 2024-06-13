// https://leetcode.com/problems/magnetic-force-between-two-balls

class Solution {
    public int maxDistance(int[] P, int m) {
        int n = P.length;
        
        Arrays.sort(P);
        
        int st = 1, ed = (P[n-1]-P[0])/(m-1);
        
        while(st<ed){
            int d = st + (ed-st+1)/2;
            
            
            boolean bool = isOk(P, d, m);
            
            // System.out.println(st + " " + ed + " d=" + d +  " " + bool); 
            
            if(bool){
                st = d;
            }else{
                ed = d-1;
            }
        }
        
        if(isOk(P, st, m))
            return st;
        else if(isOk(P, st-1, m))
            return st-1;
        
        return -1;
        
    }
    
    
    private boolean isOk(int[] P, int d, int m){
        
        int len = P.length;
        
        m--;
        int prev = P[0];
        
        for(int i=1;i<len;i++){
            
            if(P[i]-prev>=d){
                m--;
                prev = P[i];
            }
        }
        
        return m<=0;
        
    }
}