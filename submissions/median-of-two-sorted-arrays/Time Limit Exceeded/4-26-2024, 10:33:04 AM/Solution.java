// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {

        int aLen = A.length;
        int bLen = B.length;

        int len = aLen+bLen;
        int[] arr = new int[len];
        System.arraycopy(A, 0, arr, 0, aLen);
        System.arraycopy(B, 0, arr, aLen, bLen);

        if(len%2==0){
            quickSelect(arr, 0, len-1, len/2-1);
            quickSelect(arr, 0, len-1, len/2);
            double a = Double.valueOf(arr[len/2-1]);
            double b = Double.valueOf(arr[len/2]);
            return (a+b)/2;

        }else{
            quickSelect(arr, 0, len-1, len/2);
            return Double.valueOf(arr[len/2]);
        }
    }

    private void quickSelect(int[] arr, int st, int ed, int k){

        int len = arr.length;
        if(st>ed) return;

        int pivotIdx = partition2(arr, st, ed-1, ed);
        System.out.println("pivotIdx="+pivotIdx);
        swap(arr, pivotIdx, ed);
        
        if(pivotIdx==k) return;
        else if(pivotIdx<k){
            quickSelect(arr, pivotIdx+1, ed, k);
        }else{
            quickSelect(arr, 0, pivotIdx-1, k);
        }

    }


    private int partition2(int[] nums, int left, int right, int pivot){

        pivot = nums[pivot];

        while(left <= right){
            // find the left, right prepare to swap
            while(nums[left]<pivot)
                left++;
            while(nums[right]>pivot)
                right--;
            
            if(left<right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }


        return left;
    }
    


    private int partition(int[] arr , int st, int ed, int p){

        while(st<=ed){

            if(arr[st]<=arr[p]){
                st++;
            }else{
                swap(arr, st, ed);
                ed--;
            }
        }

        return st;
    }

    private void swap(int[] arr ,int st, int ed){
        int t= arr[st];
        arr[st] = arr[ed];
        arr[ed] = t;
    }
}