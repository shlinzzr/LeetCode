// https://leetcode.com/problems/wiggle-sort-ii

class Solution {
    public void wiggleSort(int[] nums) {
        
        // sort & partitiom : O(nlgn)/ 
        int len = nums.length;

        quickselect(nums, 0, len-1, len/2);
        int mid = nums[len/2];

        // for(int i=1; i<len/2; i+=2){
        //     swap(nums, i, len-i);
        // }

        int largePos = 1; //Odd position from start for larger than median numbers
        int smallPos = len%2==0 ? len-2: len-1; //Even position from end for smaller than median numbers
        int cur = 0;
        while(cur<len) {
			//Avoiding already checked even positions from the end
            if(nums[cur]<mid && (cur<smallPos || (cur>=smallPos && cur%2!=0))) {
                swap(nums, cur, smallPos);
                smallPos-=2;
            }
			//Avoiding already checked odd positions from the start
            else if(nums[cur]>mid && (largePos<cur || (largePos>=cur && cur%2==0))) {
                swap(nums, cur, largePos);
                largePos+=2;
            }
            
            else cur++;
        }
       
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