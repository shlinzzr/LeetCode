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
    
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        
        Item[] items = new Item[len];
        for(int i = 0;i < len;i++) {
            items[i] = new Item(nums[i], i);
        }
        
        int[] arr = new int[len];
        mergeSort(items, 0, len-1, arr);

        List<Integer> list = new ArrayList<>();
        for(int r : arr) 
            list.add(r);

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
        
        int smallerCounter = 0;
        
        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(items[loIdx].val<=items[hiIdx].val){

                count[items[loIdx].idx]+=smallerCounter; // 只有寫入loIdx 的時候才需要紀錄 count
                sorted[idx++] = items[loIdx++];
                
            }else{
                //    此時 items[lo] > items[hi]
                // 表示原本array 右邊有比較小的數量＋＋
                smallerCounter++; // 左邊大於右邊的時候 counter++
                sorted[idx++] = items[hiIdx++]; // 把右邊寫入sorted。啥事也沒發生
            }
        }
        
        while(loIdx<=loEnd){ // 表示hiIdx已經走到底了, 已經不會有
            count[items[loIdx].idx]+=smallerCounter;  // 只有寫入loIdx 的時候才需要紀錄 count
            sorted[idx++] = items[loIdx++];
        }
        
        while(hiIdx<=hiEnd){
            
            sorted[idx++] = items[hiIdx++];
        }
        
        System.arraycopy(sorted, 0, items, lo, len);
    }
    
}