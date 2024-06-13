// https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function

class Solution {
    public int preimageSizeFZF(int k) {
        
        long st = 0, ed = Long.MAX_VALUE;
        
        while(st<ed){
            long mid = st + (ed-st)/2;
            
            if(getCnt(mid)==k){
                return 5;
            }else if(getCnt(mid) > k){
                ed = mid-1;
                
            }else{
                st = mid+1;
            }
        }
        
        return 0;
        
        
    }
    
    private long getCnt(long n){
        
        long ans = 0;
        long x = 5;
        
        while(x<=n){
            ans += n/x;
            x*=5;
        }
        
        return ans;
        
    }
}