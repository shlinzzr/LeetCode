// https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        // x / 11^a / 5^b y 
        
        // System.out.println(x + "　"+ y);
        
        if(x==y) return 0;
        if(x<y) return y-x;
        
        
        int res= Integer.MAX_VALUE;
        
        
        if(Math.abs(x-y*5)<5)
            return x-y*5;
        
        if(Math.abs(x-y*11)<5)
            return x-y*11;
            
            
        res = Math.min(res, 1+minimumOperationsToMakeEqual(x, y*5));
        res = Math.min(res, 1+minimumOperationsToMakeEqual(x, y*11));
     
        return res;
    }
    
}