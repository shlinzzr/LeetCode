// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr) {
        
        // [5,1,3,4,2] 
        // 每次跳可以先選擇odd jump 或 even jump, odd跳完要換even, even跳完要換odd
        // odd jump : find val >= curr
        // even jump : find val <= curr
        
        
        //推導: 1. 一定從最後一個element出發 (要找走的回終點的起點)
        //     2. 因為是比大小 找值ceiling or floor 所以先想到treeMap
        //     3. 要判斷能不能走回終點, 用boolean array來記錄
        
        
        int len = arr.length;
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        
        higher[len-1]=true;
        lower[len-1]=true;
        int res =1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        map.put(arr[len-1], len-1); // val -> idx =>(2, 4)

        for(int i=len-2; i>=0; i--){ // len-1 已經是答案了 從len-2(4) 開始
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]); // null
            Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]); // lo=(2,4)
            
            if(hi!=null)
                higher[i]=lower[(int)hi.getValue()];
            
            if (lo != null) 
                lower[i] = higher[(int)lo.getValue()];
            
            if(higher[i]) 
                res++;
            
            map.put(arr[i], i);
            
            
        }
        
        return res;
    }
}