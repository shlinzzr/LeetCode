// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr) {

        int len = arr.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 1; // the last idx is always valid

        boolean[] higher = new boolean[len];
        boolean[] lower = new boolean[len];
        higher[len-1] = true;
        lower[len-1] = true;

        map.put(arr[len-1], len-1);

        for(int i=len-2; i>=0; i--){
            Integer hi = map.ceilingKey(arr[i]);
            if(hi!=null){
                lower[i] = higher[map.get(hi)];
            }

            Integer lo = map.floorKey(arr[i]);
            if(lo!=null){
                higher[i] = lower[map.get(lo)];
            }
            
            if(lower[i]) res++;

            map.put(arr[i], i);

        }

        return res;
        
    }
}