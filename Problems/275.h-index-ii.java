// https://leetcode.com/problems/h-index-ii

class Solution {
    public int hIndex(int[] C) {
        int len = C.length;
        int st=0;
        int ed = len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            boolean bool = isOk(C, mid);
            
            if(bool){
                ed=mid;
            }else{
                st=mid+1;
            }
        }
        
        return C[st]>=len-st ? len-st : 0;
        
        
    }
    
    
    private boolean isOk(int[] C, int mid){
        
        int val = C[mid]; // 3
        
        int len = C.length; // 5
        
        return len-mid <= val; //5-2-1>=val
        
    }
                                           
    
    
}