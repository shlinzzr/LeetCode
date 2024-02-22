// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {

    class Item{
        int idx;
        int val;
        public Item(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int len = nums.length;

        Item[] items = new Item[len];
        for(int i=0; i<len ;i++){
            items[i] = new Item(i, nums[i]);
        }

        int[] arr = new int[len];

        mergeSort(items, 0, len-1, arr);

        for(int i=0; i<arr.length;i++){
            res.add(arr[i]);
        }

        return res;

    }

    private void mergeSort(Item[] items, int lo, int hi, int[] arr){

        if(lo>=hi) return;

        int mid = lo+(hi-lo)/2;
        mergeSort(items, lo, mid, arr);
        mergeSort(items, mid+1, hi, arr);
        mergeHalves(items, lo, mid, mid+1, hi, arr);
   }

   private void mergeHalves(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] arr){

        int len = hiEnd-lo+1;
        Item[] sorted = new Item[len];
        int idx = 0;

        int loIdx=lo, hiIdx=hi;

        int cnt = 0;

        while(loIdx<=loEnd && hiIdx<=hiEnd){
            if(items[loIdx].val<=items[hiIdx].val){
                arr[items[loIdx].idx]+=cnt;
                sorted[idx++] = items[loIdx++];
            }else{
                cnt++;
                sorted[idx++] = items[hiIdx++];
            }
        }

        while(loIdx<=loEnd){
            arr[items[loIdx].idx]+=cnt;
            sorted[idx++] = items[loIdx++];
        }

        while(hiIdx<=hiEnd){
            sorted[idx++] = items[hiIdx++];
        }

        System.arraycopy(sorted, 0, items, lo, len);
   }
}