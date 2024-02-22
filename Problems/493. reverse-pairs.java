// https://leetcode.com/problems/reverse-pairs

class Solution {
    public int reversePairs(int[] nums) {
        // int len = nums.length;

        // int cnt =0 ;
        // // bruteforce
        // for(int j=0; j<len; j++){
        //     for(int i=0; i<j; i++){
        //         if((long)nums[i] > (long)2 * nums[j]){
        //             cnt++;
        //         }

        //     }
        // }
        // return cnt;
        int res = mergeSort(nums, 0, nums.length-1);

        for(int n: nums){
            System.out.println(n);
        }
        return res;
    }


    private int mergeSort(int[] nums, int lo, int hi){
        if(lo>=hi) return 0;
        int mid = lo + (hi-lo)/2;
        int res = 0;
        res += mergeSort(nums, lo, mid);
        res +=mergeSort(nums, mid+1, hi);
        res +=mergeHalves(nums, lo, mid, mid+1, hi);
        return res;
    }
    
    
    private  int mergeHalves(int[] nums, int lo, int loEnd, int hi, int hiEnd){
        
        int cnt =0;
        int loIdx = lo, hiIdx=hi;
        int len = hiEnd-lo+1;
        int[] sorted = new int[len];
        int idx =0;

         int p = lo, q = hi;
        while (p <= loEnd && q <= hiEnd) {
            if ((long) nums[p] > 2 * (long) nums[q]) {
                cnt += loEnd - p + 1;
                q++;
            } else {
                p++;
            }
        }
        

        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(nums[loIdx]<=nums[hiIdx]){
                sorted[idx++] = nums[loIdx++];
            }else{
                sorted[idx++] = nums[hiIdx++];        
            }
        }
        
        while(loIdx<=loEnd){
            sorted[idx++] = nums[loIdx++];
        }
        
        while(hiIdx<=hiEnd){
            sorted[idx++] = nums[hiIdx++];
        }
        
        System.arraycopy(sorted, 0, nums, lo, len);
        return cnt;
    }
    


    private int mergeSort2(int[] nums, int lo, int hi){
        if(lo>=hi) return 0;

        int mid = lo+(hi-lo)/2;

        int res = 0;
        res += mergeSort2(nums, lo, mid);
        res += mergeSort2(nums, mid+1, hi);
        res += mergeHalves2(nums, lo, mid, mid+1, hi);
        return res;
    }

    private int mergeHalves2(int[]nums, int lo, int loEnd, int hi, int hiEnd){

        int cnt =0;

        int loIdx = lo, hiIdx=hi;
        int len = hiEnd-lo+1;
        int[] tmp = new int[len];
        int idx= 0 ;
        

        int p = lo, q = hi;
        while (p <= loEnd && q <= hiEnd) {
            if ((long) nums[p] > 2 * (long) nums[q]) {
                cnt += loEnd - p + 1;
                q++;
            } else {
                p++;
            }
        }
        
        while(loIdx<=loEnd && hiIdx<=hiEnd){

            if(nums[loIdx]<=nums[hiIdx]){
                tmp[idx++] = nums[loIdx++];
            }else{
                tmp[idx++] = nums[hiIdx++];
            }
        }

        while(loIdx<=loEnd){
            tmp[idx++] = nums[loIdx++];
        }

        while(hiIdx<=hiEnd){
            tmp[idx++] = nums[hiIdx++];
        }

        System.arraycopy(tmp, 0, nums, lo, len);

        return cnt;
    }
}