// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {

        mergesort(nums, 0, nums.length-1);
        
    }

    private void mergesort(int[] nums, int st, int ed){
        if(st>=ed) return;

        int mid= st+(ed-st)/2;
        mergesort(nums, st, mid);
        mergesort(nums, mid+1, ed);
        mergeHalves(nums, st, mid, mid+1, ed);
    }

    private void mergeHalves(int[] nums, int lo, int loEnd, int hi, int hiEnd){

        int i=lo, j=hi;
        int len = hiEnd-lo+1;

        int[] tmp = new int[len];
        int idx= 0;

        while(i<=loEnd && j<=hiEnd){
            if(nums[i]<=nums[j]){
                tmp[idx++] = nums[i++];
            }else{
                tmp[idx++] = nums[j++];
            }
        }

        while(i<=loEnd){
            tmp[idx++] = nums[i++];
        }

        while(j<=hiEnd){
            tmp[idx++] = nums[j++];
        }

        System.arraycopy(tmp, 0, nums, lo, len);
    }
}