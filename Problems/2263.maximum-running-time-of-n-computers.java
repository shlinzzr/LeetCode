// https://leetcode.com/problems/maximum-running-time-of-n-computers

class Solution {
    public long maxRunTime(int n, int[] batteries) {
       
        Arrays.sort(batteries);
        
        int max = 0;
        
        for(int b : batteries){
            max = Math.max(max, b);
        }
        
        long st=0, ed=Long.MAX_VALUE/n;
        
        while(st<ed){
            long mid = ed-(ed-st)/2; // overflow
            System.out.println(st + " " + ed + " " + mid);
            if(isOk(batteries, mid, n)){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
      
        System.out.println(st);
        
        if(isOk(batteries, st, n)){
            return st;
        }else if(isOk(batteries, st-1, n))
            return st-1;
        
//         long minutes = 0;
        
//         for (int b : batteries)
//                 minutes += Math.min((long)b, st+1);
//         if(minutes>=n*(st+1))
//             return st+1;
        
        
        return st;
        
        
    }
    
    private boolean isOk(int[] batteries, long mid, int n){
        
        long sum=0;
        
        for(int b : batteries){
            sum += Math.min(mid, b);
            if(sum>=mid*n)
                return true;
        }
        return false;
    }
    
    
      /*
        0 977906 488953
488953 977906 733430
733430 977906 855668
855668 977906 916787
916787 977906 947347
947347 977906 962627
962627 977906 970267
970267 977906 974087
974087 977906 975997
975997 977906 976952
976952 977906 977429
977429 977906 977668
977668 977906 977787
977787 977906 977847
977847 977906 977877
977877 977906 977892
977892 977906 977899
977899 977906 977903
977903 977906 977905
977905 977906 977906
977906*/
}