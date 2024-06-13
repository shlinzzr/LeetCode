// https://leetcode.com/problems/maximum-tastiness-of-candy-basket

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
       
        int st=0, ed=Integer.MAX_VALUE;
        while(st<ed){
            
            int mid = ed-(ed-st)/2;
            
            if(ok(price, k , mid)){
                
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
        
    }
    
    private boolean ok(int[] price, int k, int mid){
        
        int cnt=1;
        int curr=price[0];
        for(int i=0; i<price.length; i++){
            
            if(price[i]>= curr+mid){
                curr = price[i];
                cnt+=1;
            }
        }
        
        return cnt>=k;
    }
}