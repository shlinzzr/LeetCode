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

        //此時的 item == nums[i]
        // [2,0,1] => st=0, mid=1, ed=2 => [2,0] , [1]
        // focus [2,0] => 2>0 => cnt+=1
        //       lo hi
        // sorted[0] = 0;
        // lo<=loEnd : sorted[1] = 2, arr[item[lo].idx]=cnt

        // 重點是為什麼 nums[loIdx] <= nums[hiIdx] 把cnt 寫入arr[loIdx]
        // => a. 應該是看當 nums[loIdx] > nums[hiIdx]的時候 表示右邊比較小 於是cnt++;
        //    b.  當nums[loIdx] <= nums[hiIdx], loIdx 準備寫入 於是把cnt 加進去




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