// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left =0;
        int right = 0;
        
        for(int w: weights){
            left = Math.max(left, w);
            right += w;
        }
        
        while(left<right){
            
            int mid = left + (right-left)/2;
            if(possible(weights, days, mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        
        return left;
        
        
        
        
    }
    
    
    private boolean possible(int[] weights, int days, int capacity){
        
        int i=0; 
        int sum = 0;
        int d=1;
        for(; i<weights.length; i++){
            
            if(sum+weights[i]>capacity){
                sum = weights[i];
                d++;
            }else
                sum+= weights[i];
        }
        
        return d<=days;
        
        
        
        
    }
}