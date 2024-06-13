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
            long mid = ed-(ed-st)/2, minutes=0;
            
            if(isOk(batteries, mid, n)){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        
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
    
    
    
}