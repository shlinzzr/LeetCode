// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        
//         i -> j
//         odd : arr[i]<= arr[j](smallest val with smallest idx)
//         even : arr[i]>= arr[j](largest val with smallest idx)
        
//         good: can reach end of arr (arr.length-1)
//         return # of good idx
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        
        higher[len-1] = true;
        lower[len-1] = true;
        map.put(arr[len-1], len-1);
        
        /*
        higher            true
                    val
        lower             true
        */
        
        int res = 1; // len-1就是答案
        for(int i=len-2; i>=0; i--){
            
            int val = arr[len-2];
            
            Integer hi = map.ceilingKey(val);
            if(hi!=null){
                lower[i] = higher[map.get(hi)];
            }
            
            Integer lo = map.floorKey(val);
            if(lo!=null){
                higher[i] = lower[map.get(lo)];   
            }
            
            if(lower[i]) res++;
            
            map.put(val, i);
            
            
        }
        return res;
    }
}