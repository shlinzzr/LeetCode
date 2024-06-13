// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr) {
        
        // [5,1,3,4,2] 
        // 每次跳可以先選擇odd jump 或 even jump, odd跳完要換even, even跳完要換odd
        // odd jump  : arr[i] <= arr[j]
        // even jump : arr[i] >= arr[j]
        
        //推導: 1. 一定從最後一個element出發 (要找有幾個起點可走回終點)
        //      2. 因為是比大小 找值ceiling or floor 所以先想到treeMap
        //      3. 要判斷能不能走回終點, 用兩個boolean array來記錄
        
        
        int len = arr.length;
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        
        higher[len-1]=true;
        lower[len-1]=true;
        int res =1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        map.put(arr[len-1], len-1); // val, idx => (2, 4)

        for(int i=len-2; i>=0; i--){ // len-1 已經是答案了 從len-2 (4) 開始
            int val = arr[i];
            Integer hi = map.ceilingKey(val);
            if(hi!=null)
                lower[i] = higher[map.get(hi)];
            
            Integer lo = map.floorKey(val);
            if (lo != null) 
                higher[i] = lower[map.get(lo)]; 
            
            // 表示當我在len-2的地方。用lower[len-2](even jump)可以找到 val=2 which idx==len-1 is end
            // 之後有任何任higher跳完之後來找lower 若找到我表示這個src也到的了終點
            
            
            if(lower[i]) //每個idx出發的 "odd" even jump 從找大開始 所以只看higher
                res++;
            
            map.put(arr[i], i);
        }
        
        return res;
    }
}