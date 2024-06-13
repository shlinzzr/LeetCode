// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(len<m*k)
            return -1;
        
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int b : bloomDay){
            min = Math.min(min, b);
            max = Math.max(max, b);
        }
        
        int st = min, ed = max;
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            boolean bool = isOk(bloomDay, mid, m, k);
            // System.out.println(st + " " + ed + " mid="+ mid + " " + bool);
            
            if(bool){
                ed = mid;
            }else {
                st = mid+1;            
            }
        }
        
        
         boolean bool = isOk(bloomDay, st, m, k);
        // System.out.println(st + " " + ed  + " " + bool);
            
        if(isOk(bloomDay, st, m, k))
            return st;
        
        else if(isOk(bloomDay, st-1, m, k))
            return st-1;
                
        return -1;
        
        
        
    }
    
    
    private boolean isOk(int[]bloomDay, int mid, int m, int k){
        
        int len = bloomDay.length;
        
        int cnt = 0;
        
        int flower =0, bouq=0;
        
        for(int i=0; i<len; i++){
            // System.out.println("i="+i);
            
            if(bloomDay[i]>mid){
                flower=0;
                
            }else if(++flower >=k){
                bouq++;
                flower=0;
            }
            
            // if(bloomDay[i]<=mid){
            //     boolean flag = true;
            //     int t=1;
            //     for(int j=i+1; j<len&& j<i+k; j++){
            //         if(bloomDay[j]>mid){
            //             flag = false;
            //             break;
            //         }
            //         t++;
            //     }
            //     if(flag && t==k){
            //         cnt++;
            //         i += k-1;
            //     }
            // }
        }
        
        // System.out.println("isOk:"+mid + " cnt="+cnt);
        
        return bouq >= m;
        
        
        
        
        
    }
}