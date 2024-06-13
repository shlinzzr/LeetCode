// https://leetcode.com/problems/maximize-win-from-two-segments

class Solution {
    public int maximizeWin(int[] P, int k) {
        int len = P.length;
        
        // if(k==0)
        //     return 0;
        
        if(P[len-1]-P[0]<=2*k)
            return len;
        
        

        //huifeng https://www.youtube.com/watch?v=0Tjuy464sP8
        
        int[] pre = new int[len];
        int[] post = new int[len];
        
        int max= 0 ; 
        
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            while(P[ed]-P[st]>k){
                st++;
            }
            
            max = Math.max(max, ed-st+1);
            pre[ed] = max;
        }
        
        max = 0;
        int ed=len-1;
        for(st=len-1; st>=0; st--){
            while(P[ed]-P[st]>k){
                ed--;
            }
            
            
            max = Math.max(max, ed-st+1);
            post[st] = max;
        }
        
        // System.out.println(pre[0] + " " + post[0]);
        int res = 0;
        for(int i=0; i+1<len ; i++){
            res = Math.max(res, pre[i]+post[i+1]);
        }
        
        return res;
        
    }
}