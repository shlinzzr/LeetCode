// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {

/*
Approach 1: MergeSort : O((n + m) * log(n + m)); => copy and find mid
Approach 2: Two-Pointer Method  O(n + m), 
Approach 3: Binary Search O(logm/logn)
*/

    public double findMedianSortedArrays(int[] A, int[] B) {
        
        int alen=A.length;
        int blen=B.length;

        if(alen+blen==0) 
            return 0;
        
        int[] arr = new int[alen+blen];
        System.arraycopy(A, 0, arr, 0, alen);
        System.arraycopy(B, 0, arr, alen, blen);
        int len = alen+blen;
        
        if(len%2==0){
            quickselect(arr, 0, len-1, len/2-1);
            quickselect(arr, 0, len-1, len/2);
        }else{
            quickselect(arr, 0, len-1, len/2);
        }
        
        if(len%2==0) return (Double.valueOf(arr[len/2]) + Double.valueOf(arr[len/2-1]))/2;
        
        return Double.valueOf(arr[len/2]);
    }
    
    private void quickselect(int[] arr, int st, int ed, int k){

// System.out.println("quickselect st="+st + " ed="+ed);
        
        if(st>=ed) return;
        
        int pivotIdx = partition(arr, st, ed-1, ed);
        swap(arr, pivotIdx, ed);
        
        // for(int a :arr){
        //     System.out.print(a + " ,");
        // }

        //    System.out.println("pivotIdx="+pivotIdx);

        if(k==pivotIdx){
            return;
        }else if(k<pivotIdx){
            quickselect(arr, st, pivotIdx-1, k);
        }else{
            quickselect(arr, pivotIdx+1, ed, k);
        }
    }
    
    private int partition(int[] arr, int st, int ed, int p){
        
        while(st<=ed){
            
            if(arr[st]>arr[p]){
                swap(arr, st, ed);
                ed--;
            }else
                st++;
        }
        
        return st;
    }
    
    private void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
    
    
    
//     public double findMedianSortedArrays(int[] A, int[] B) {
        
//         int alen=A.length;
//         int blen=B.length;

//         if(alen+blen==0) 
//             return 0;
//         //because of idx2=half-idx1,  we want len1 < len2
//         if(alen>blen) 
//             return findMedianSortedArrays(B, A);

//         int len = alen + blen;
//         int half = len/2;

//         //想法: 針對amid 做binarySearch, bmid = half-amid
//         // and find acurr < bnext && bcurr<anext
//         // else : 
//         int left=0, right=alen-1;
       
//         while(true){
//             int amid = right-(right-left)/2; // a拿了 amid+1個
//             int bmid = half-(amid+1)-1; // b 要拿 half-(amid+1)個, 轉成idx變成 half-(amid+1)-1

//             int acurr = (amid>=0)     ? A[amid]   : Integer.MIN_VALUE; // if not legal, use bcurr
//             int anext = (amid+1<alen) ? A[amid+1] : Integer.MAX_VALUE; // if not legal, use bnext
//             int bcurr = (bmid>=0)     ? B[bmid]   : Integer.MIN_VALUE; // if not legal, use acurr
//             int bnext = (bmid+1<blen) ? B[bmid+1] : Integer.MAX_VALUE; // if not legal, use anext

//             if(acurr<=bnext && bcurr<= anext){ // found what we want
                
//                 if(len%2==0)
//                     return ((double)Math.max(acurr, bcurr) + (double)Math.min(anext, bnext))/2;
//                 else
//                     return (double) Math.min(anext, bnext); //median is smaller one  
                
//             }else{
//                  // means "bcurr>anext" or "acurr>bnext"
//                 if(bcurr>anext) // 表示a太小, left=amid+1
//                     left = amid+1; 
//                 else if(acurr>bnext) // 表示a太大, right=amid-1
//                     right = amid-1;
//             }
//         }

//     }
// }