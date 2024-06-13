// https://leetcode.com/problems/maximize-the-minimum-powered-city

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int len = stations.length;
        long st =0, ed=Long.MAX_VALUE;
        
        while(st<ed){
            
            long mid = ed- (ed-st)/2;
            // System.out.println(mid  + " " +isOK(stations, r, k , mid) );
            if(isOK(stations, r, k , mid)){
                st = mid;
                
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
    }
    
     boolean isOK(int[] stations,  int r, int k, long mid){
        long sum=0;
        int n=stations.length;
        long[] ans = new long[n];
            for(int i=0;i<n;i++)
            ans[i]=stations[i];
        
        for(int i=0;i<r;i++)
            sum+=ans[i];
        for(int i=0;i<n;i++){
            sum+=((i+r<=n-1)?ans[i+r]:0)-((i-r-1>=0)?ans[i-r-1]:0); //sliding window
            if(sum<mid){
                    if((mid-sum)>k)
                        return false;
                if(i+r<=n-1) ans[i+r]+=(mid-sum); //greedy
                k-=(mid-sum);
                sum=mid;
            }
        }
        return true;
    }
    
//     private boolean isOK(int[] stations, int r, int k, long mid){
//         int len = stations.length;
        
//         int win = 2*r;
        
//         long curr = 0;
        
//         int st=0;
//         for(int ed=0; ed<len ; ed++){
            
//             curr += stations[ed];
            
//             if(ed!=len-1 && ed-st<r)
//                 continue;
            
//             if(ed-st>win){
//                 curr-= stations[st];
//                 st++;
//             }
                
//             if(curr>=mid)
//                 continue;
            
//             if(k>0 && curr+k >= mid){
                
//                 // System.out.println(curr + " " + k);
                
//                 k -= mid-curr;
//                 continue;
//             }
            
//             if(curr<mid)
//                 return false;
//         }
        
//         return true;
        
        
        
//     }
    
}