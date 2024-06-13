// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;
        
        // Arrays.sort(weights);
        
        
        int total = 0;
        int min = Integer.MAX_VALUE;
        for(int w : weights){
            total += w;
            min = Math.min(min, w);
        }
        
        int st = min, ed = total;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(isOk(weights, days, mid, total)){
                ed = mid;
            }else{
                st= mid+1;
            }
        }
        
        return st;
    
   }
    
    private boolean isOk(int[] weights, int days, int capacity, int total){
        
        int len = weights.length;
        
        // System.out.println("isOk : " + capacity);
        
        
        int sum = 0;
        int d=1;
        for(int i=0; i<len; i++){
            if(sum+weights[i]>capacity){
                sum = weights[i];
                d++;
            }else{
                sum += weights[i];
            }
        }
        
         return d<=days;
        
        
    }
}