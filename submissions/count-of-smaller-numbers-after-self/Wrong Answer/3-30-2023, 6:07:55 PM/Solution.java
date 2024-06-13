// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    
    int[] indexes;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        
        int[] count = new int[len];
        indexes = new int[len];
        for(int i = 0;i < len;i++) {
            indexes[i] = i;
        }
        
        
        mergeSort(nums, 0, len-1, count);
        
        List<Integer> list = new ArrayList<>();
        for(int r: count) list.add(r);
        return list;
    }
    
   
    private void mergeSort(int[] nums, int lo, int hi, int[] count){
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(nums, lo, mid, count);
        mergeSort(nums, mid+1, hi, count);
        mergeHalves(nums, lo, mid, mid+1, hi, count);
    }
    
    private void mergeHalves(int[] nums, int lo, int loEnd, int hi, int hiEnd, int[] count){
        
        int loIdx = lo, hiIdx=hi;
        int len = hiEnd-lo+1;
        int[] sorted = new int[len];
        int idx =0;
        
        int rightCounter = 0;
        
        
        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(nums[loIdx]<=nums[hiIdx]){
                
                count[indexes[loIdx]]+=rightCounter;
                sorted[idx++] = nums[loIdx++];
                
            }else{
                rightCounter++;
                sorted[idx++] = nums[hiIdx++];        
            }
        }
        
        while(loIdx<=loEnd){
             count[indexes[loIdx]]+=rightCounter;
            sorted[idx++] = nums[loIdx++];
        }
        
        while(hiIdx<=hiEnd){
            sorted[idx++] = nums[hiIdx++];
        }
        
        System.arraycopy(sorted, 0, nums, lo, len);
    }
    
}