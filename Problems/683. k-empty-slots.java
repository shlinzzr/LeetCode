// https://leetcode.com/problems/k-empty-slots

class Solution {
    public int kEmptySlots(int[] days, int k) {
        // bulbs[i] = x, i=0~n-1, 打開第x個bulb
        
        //給一個k 回傳最小天數使得 兩個打開的bulbs相距正好 k個closed
        // x x x x o x x x x x o x x x
        //           ^^^^^^^^^
        //             k=5個
        
        int len = days.length;
        if(k>len-2)
            return -1;
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<len; i++){
            
            int idx = days[i]-1;
            Integer hi = set.higher(idx);
            Integer lo = set.lower(idx);
            
            if(hi!=null && hi-idx-1==k){
                return i+1;
            }
            
            if(lo!=null && idx-lo-1==k){
                return i+1;
            }
            
            set.add(idx);
            
            
        }
        
        return -1;
    }
}