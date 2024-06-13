// https://leetcode.com/problems/h-index-ii

class Solution {
    public int hIndex(int[] C) {
        int len = C.length;
        int st=0;
        int ed = len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            boolean bool = isOk(C, mid);
            
            // System.out.println(mid + " " + bool);
            
            
            if(bool){
                st=mid;
            }else{
                ed=mid-1;
            }
        }
        
        return C[st];
        
    }
    
    
    private boolean isOk(int[] C, int mid){
        
        int val = C[mid]; // 3
        
        int len = C.length; // 5
        
        return len-mid >=val; //5-2-1>=val
        
    }
                                           
    
    
}