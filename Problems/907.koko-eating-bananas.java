// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int len = piles.length;
        if(len>h)
            return -1;
        
        int max = 0;
        for(int p : piles){
            max = Math.max(max, p);
        }
        
        if(len==h)
            return max;
        
        int low=1, high=max;
        while(low<high){
            
            int mid = low + (high-low)/2;
            
            if(check(piles, mid, h)){
                high = mid;
                
            }else{
                low = mid+1;
            }
        }
        
        return low;
        
        
        
        
    }
    
    
    private boolean check(int[] piles, int k, int h){
        
        int cnt =0;
            
        for(int j=0; j<piles.length; j++){
            
            cnt+=piles[j]/k;
            
            if(piles[j]%k!=0)
                cnt++;
        }
        
        return cnt<=h;
        
    }
}