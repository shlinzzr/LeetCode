// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    public int maxScore(int[] cp, int k) {
        
        int len = cp.length;
        
        int total=0;
        int st =0;
        int curr = 0;
        int min = Integer.MAX_VALUE;
        for(int ed=0; ed<len;ed++){
            total+=cp[ed];
            curr+=cp[ed];
            
            if(len-(ed-st+1)>k)
                continue;
            
            if(len-(ed-st+1)<k){
                curr-=cp[st++];
            }
            
            min = Math.min(min, curr);
        }
        
        
        
        return total-min;
        
        
    }
}