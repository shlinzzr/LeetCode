// https://leetcode.com/problems/minimum-space-wasted-from-packaging

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        // T(logN * K * M) == O(lgN) * KM < 10^10
        // tricky part is sum(boxes[j].length) === O(KM) 
        long inf = (long)1e11;
        long total=0, mod = (long)1e9 + 7;
        Arrays.sort(packages);
        for(int p : packages){
            total+=p;
        }
        
        
        
        long min = inf;
        
        for(int[] arr : boxes){
            Arrays.sort(arr);
            
            if(arr[arr.length-1] < packages[packages.length-1])
                continue;
            
            long cur = 0, st=0, ed=0;
            for(int b : arr){
                
                ed = binarySearch(packages, b);
                cur += b * (ed-st);
                st = ed;
            }
            
            
            min = Math.min(min , cur);
            
        }
        
     
        
        return min < inf ? (int)((min - total) % mod) : -1; 
        
        
        
        
        
        
    }
    
    private int binarySearch(int[] packages, int b){
        
        int st=0, ed=packages.length;
        
        while(st<ed){
            
            int m = (st+ed)/2;
            if(packages[m]<b){
                st=m+1;
            }else{
                ed=m;
            }
        }
        
        return st;
        
        
        
    }
    
}