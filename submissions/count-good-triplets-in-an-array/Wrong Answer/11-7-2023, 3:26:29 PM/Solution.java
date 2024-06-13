// https://leetcode.com/problems/count-good-triplets-in-an-array

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int len = nums1.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<len; i++){
            map.put(nums1[i], i);
        }

        for(int i=0; i<len; i++){
            nums2[i] = map.get(nums2[i]);
        }

        LeetCode315 lc315 = new LeetCode315();

        int[][] rt = lc315.countSmallerAndLarger(nums2); // 0: smaller, 1:larger

        long res = 0;
        int M = (int) 1e9+7;
        for(int i=0; i<len; i++){
            res += (long)rt[i][0] * (long)rt[i][1];
        }

        return res;


    }
}


class LeetCode315{

    class Item{
        int idx;
        int val;
        public Item(int idx, int val){
            this.idx=idx;
            this.val=val;
        }
    }

    public int[][] countSmallerAndLarger(int[] nums){

        int len = nums.length;
        int[][] res = new int[len][2];

        Item[] items = new Item[len];
        for(int i=0; i<len; i++){
            items[i] = new Item(i, nums[i]);
        }
        mergesort(items, 0, len-1, res);
        return res;
    }

    public void mergesort(Item[] items, int st, int ed, int[][] res){
        if(st>=ed) return;

        int mid = st + (ed-st)/2;
        mergesort(items, st, mid, res);
        mergesort(items, mid+1, ed, res);
        mergeHalves(items, st, mid, ed, res);
    }

    public void mergeHalves(Item[] items, int st, int mid, int ed, int[][] res){

        int lo = st, loEnd=mid;
        int hi = mid+1, hiEnd=ed;
        int len = ed-st+1;
        Item[] tmp = new Item[len];
        int idx = 0;

        // 用來算左邊跟右邊有幾個
        int smallerCounter=0;
        int leftCounter=0;

        // res = new int[len][2], => 0用來記錄smaller, 1用來記錄larger

        while(lo<=loEnd && hi<=hiEnd){

            if(items[lo].val<=items[hi].val){
                // 現在準備寫入lo到tmp, 此時也記錄左邊被寫入了幾個, 

                //如果lo<hi: 1.leftCounter++, 2. 在res[lo][0] 寫入(或加上)rightCounter
                leftCounter++;
                res[items[lo].idx][0]+=smallerCounter;
                tmp[idx++] = items[lo++];

            }else{
                 // 現在準備寫入hi到tmp, 此時也記錄左邊被寫入了幾個


                //反之: 1. rightCounter++, 2. 在res[hi][1] 寫入(或加上)目前的leftCounter
                smallerCounter++; // 左半大於右半的時候, counter++
                res[items[hi].idx][1]+=leftCounter;
                tmp[idx++] = items[hi++];
            }
        }

        while(lo<=loEnd){
            res[items[lo].idx][0]+=smallerCounter;
            tmp[idx++] = items[lo++];
        }

        while(hi<=hiEnd){
            res[items[hi].idx][1]+=leftCounter;
            tmp[idx++] = items[hi++];
        }

        System.arraycopy(tmp, 0, items, st, len);
    }


}