// https://leetcode.com/problems/wiggle-sort-ii

class Solution {
    public void wiggleSort(int[] nums) {
        
        // sort & partitiom : O(nlgn)/ 
        int len = nums.length;

        int n= len;
        int m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);

        quickselect(nums, 0, len-1, len/2);
        int median = nums[len/2];

        

        // for(int i=1; i<len/2; i+=2){
        //     swap(nums, i, len-i-len/2);
        // }
       
        
        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }
            
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    private void quickselect(int[] nums, int st, int ed, int k){

        if(st>=ed) return;

        // select rightmost as pivot & return pivotIdx where rightmost value shoule be
        int pivotIdx = partition_select(nums, st, ed-1, ed);
        swap(nums, pivotIdx, ed);

        if(k==pivotIdx) return;
        if(k<pivotIdx)
            quickselect(nums, st, pivotIdx, k);
        else 
            quickselect(nums, pivotIdx+1, ed, k);
    }

    private int partition_select(int[] nums, int st, int ed, int p){
        while(st<=ed){
            if(nums[st]>nums[p]){
                swap(nums, st, ed);
                ed--;
            }else 
                st++;
        }

        return st;
    }

    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}