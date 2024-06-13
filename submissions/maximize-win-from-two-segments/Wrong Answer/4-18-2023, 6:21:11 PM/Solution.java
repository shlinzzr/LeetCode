// https://leetcode.com/problems/maximize-win-from-two-segments

class Solution {
    public int maximizeWin(int[] P, int k) {
        int len = P.length;
        
        if(P[len-1]-P[0]<k)
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
        
        
        int res = 0;
        for(int i=0; i+1<len ; i++){
            res = Math.max(res, pre[i]+post[i+1]);
        }
        
        return res;
        
        
        
        
        
//         boolean first=false;
//         boolean sec = false;
        
        
//         int cnt = 0;
        
//         for(int i=len-1; i>=k; i--){
            
//             if(first==false)
//                 first=true;
//             else if(sec==false)
//                 sec=true;
//             else 
//                 break;
            
            
//             int ed = P[i]; 
//             int st = P[i-k];
            
            
//             // System.out.println(st + " " + ed);
            
//             while(i>=0 && P[i]>=st && P[i]<=ed ){
                
//                 // System.out.println(i);
                
//                 i--;
//                 cnt++;
//             }
//             i++;
//         }
        
//         return cnt;
    }
}