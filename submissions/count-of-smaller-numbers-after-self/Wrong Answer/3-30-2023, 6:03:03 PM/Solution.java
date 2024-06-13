// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        
        int[] res = new int[len];
        
        mergeSort(nums, 0, len-1, res);
        
        List<Integer> list = new ArrayList<>();
        for(int r: res) list.add(r);
        return list;
    }
    
   
    private void mergeSort(int[] nums, int lo, int hi, int[] res){
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(nums, lo, mid, res);
        mergeSort(nums, mid+1, hi, res);
        mergeHalves(nums, lo, mid, mid+1, hi, res);
    }
    
    private void mergeHalves(int[] nums, int lo, int loEnd, int hi, int hiEnd, int[] res){
        
        int loIdx = lo, hiIdx=hi;
        int len = hiEnd-lo+1;
        int[] sorted = new int[len];
        int idx =0;
        
        int rightCounter = 0;
        
        
        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(nums[loIdx]<=nums[hiIdx]){
                
                res[loIdx]+=rightCounter;
                sorted[idx++] = nums[loIdx++];
                
            }else{
                rightCounter++;
                sorted[idx++] = nums[hiIdx++];        
            }
        }
        
        while(loIdx<=loEnd){
             res[loIdx]+=rightCounter;
            sorted[idx++] = nums[loIdx++];
        }
        
        while(hiIdx<=hiEnd){
            sorted[idx++] = nums[hiIdx++];
        }
        
        System.arraycopy(sorted, 0, nums, lo, len);
    }
    
}