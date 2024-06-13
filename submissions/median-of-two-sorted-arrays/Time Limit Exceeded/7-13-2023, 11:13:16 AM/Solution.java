// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    
    // https://www.youtube.com/watch?v=8NyQRJ1Khvw
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        
        int alen = A.length;
        int blen = B.length;
        int len = alen+blen;
        int half = len/2; // 1
        
        if(alen>blen)
            return findMedianSortedArrays(B, A);
        
        int left = 0;
        int right = alen-1; //0
        
        while(true){
            
            int amid = (left+right)/2; // 0 //1
            int bmid = half-amid-2;
            
            int acurr = (amid>=0) ? A[amid] : Integer.MIN_VALUE; // 2
            int anext = (amid+1<alen) ? A[amid+1] : Integer.MAX_VALUE; // max
            int bcurr = (bmid>=0) ? B[bmid] : Integer.MIN_VALUE; //min
            int bnext = (bmid+1<blen) ? B[bmid+1] : Integer.MAX_VALUE; // 1
            
            if(acurr<=bnext && bcurr<= anext){
                
                if(len%2==0)
                    return ((double)Math.max(acurr, bcurr) + (double)Math.min(anext, bnext))/2;
                else
                    return (double) Math.min(acurr, bcurr);
                
            }else{
                
                if(bcurr>anext){
                    left = amid+1; // 1
                }else{
                    right = amid-1;
                }
            }
            
            
            
        }
        
        
    }
}