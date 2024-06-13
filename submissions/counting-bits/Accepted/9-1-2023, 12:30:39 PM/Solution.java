// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];
        
        for(int i=0; i<=n; i++){
            res[i] = getBit(i);
        }
        return res;
        
    }
    
    
    private int getBit(int n){
        
        if(n==1)
            return 1;
        if(n==0)
            return 0;
        
        if(n%2==0)
            return getBit(n/2);
        
        
        return 1+getBit(n/2);
            
        
    }
}