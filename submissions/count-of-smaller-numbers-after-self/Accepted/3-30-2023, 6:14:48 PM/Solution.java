// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    
    class Item{
        int val;
        int idx;
        public Item(int val, int idx){
            this.val= val;
            this.idx =idx;
        }
    }
    
    
    
    int[] indexes;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        
        
        int[] count = new int[len];
        
        Item[] items = new Item[len];
        for(int i = 0;i < len;i++) {
            items[i] = new Item(nums[i], i);
        }
        
        mergeSort(items, 0, len-1, count);
        
        List<Integer> list = new ArrayList<>();
        for(int r: count) list.add(r);
        return list;
    }
    
   
    private void mergeSort(Item[] items, int lo, int hi, int[] count){
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid+1, hi, count);
        mergeHalves(items, lo, mid, mid+1, hi, count);
    }
    
    private void mergeHalves(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count){
        
        int loIdx = lo, hiIdx=hi;
        int len = hiEnd-lo+1;
        Item[] sorted = new Item[len];
        int idx =0;
        
        int rightCounter = 0;
        
        
        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(items[loIdx].val<=items[hiIdx].val){
                
                count[items[loIdx].idx]+=rightCounter;
                sorted[idx++] = items[loIdx++];
                
            }else{
                rightCounter++;
                sorted[idx++] = items[hiIdx++];        
            }
        }
        
        while(loIdx<=loEnd){
            count[items[loIdx].idx]+=rightCounter;
            sorted[idx++] = items[loIdx++];
        }
        
        while(hiIdx<=hiEnd){
            sorted[idx++] = items[hiIdx++];
        }
        
        System.arraycopy(sorted, 0, items, lo, len);
    }
    
}