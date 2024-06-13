// https://leetcode.com/problems/divide-chocolate

class Solution {
    public int maximizeSweetness(int[] sw, int k) {
        int len = sw.length;
        
        int total= 0;
        for(int s : sw){
            total+=s;
        }
        int st =0, ed=total;
        while(st<ed){
            
            int mid = ed-(ed-st)/2;
            
            if(isOk(sw, mid, k+1)){
                st=mid;
            }else{
                ed=mid-1;
            }
        }
        
        return st;
        
        
    }
    
    private boolean isOk(int[] sw, int mid, int k){
        int cnt =0 ;
        
        int sum =0;
        for(int i=0; i<sw.length; i++){
            sum+=sw[i];
            if(sum>=mid){
                cnt++;
                sum=0;
            }
                
        }
        
        return cnt>=k;
        
    }
    
}