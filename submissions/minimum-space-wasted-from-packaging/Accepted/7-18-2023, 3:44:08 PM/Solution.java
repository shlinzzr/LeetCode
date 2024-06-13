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
                
                if(st>=packages.length ||b<packages[(int)st])
                    continue;
                
                ed = binarySearch(packages, b);
                
                 // System.out.println(st + " " + ed + " " + b * (ed-st+1) + " " + cur + " b="+ b);
                
                cur += b * (ed-st+1);
                st = ed+1;
            }
            
           
            min = Math.min(min , cur);
            
        }
        
     
        
        return min < inf ? (int)((min - total) % mod) : -1; 
        
        
        
        
        
        
    }
    
    private int binarySearch(int[] packages, int b){
        
        int st=0, ed=packages.length-1;
        
        while(st<ed){
            
            int m = (st+ed+1)/2;
            if(packages[m]<=b){
                st=m;
            }else{
                ed=m-1;
            }
        }
        
        return st;
        
        
        
    }
    
}