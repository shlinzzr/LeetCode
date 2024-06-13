// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    
    // https://www.youtube.com/watch?v=5hNWtR2EcrU
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        
        int alen = A.length;
        int blen = B.length;
        int len = alen+blen;
        int half = len/2;
        
        if(alen>blen)
            return findMedianSortedArrays(B, A);// Ａ長 Ｂ短
        
        //想法: 針對amid 做binarySearch, bmid = half-amid


        int left = 0;
        int right = alen-1;
        int cnt=0;

        
        while(true){ //一定存在median

            int amid = right - (right-left)/2;  // 找右傾
            int bmid = half-amid-2;
            
            int acurr = (amid>=0) ? A[amid] : Integer.MIN_VALUE; // 2
            int anext = (amid+1<alen) ? A[amid+1] : Integer.MAX_VALUE; // max
            int bcurr = (bmid>=0) ? B[bmid] : Integer.MIN_VALUE; //min
            int bnext = (bmid+1<blen) ? B[bmid+1] : Integer.MAX_VALUE; // 1
            
            // System.out.println("acurr=" + acurr + " anext=" + anext + " bcurr=" + bcurr + " bnext=" + bnext  );
            
            if(acurr<=bnext && bcurr<= anext){
                
                if(len%2==0)
                    return ((double)Math.max(acurr, bcurr) + (double)Math.min(anext, bnext))/2;
                else
                    return (double) Math.min(anext, bnext);
                
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