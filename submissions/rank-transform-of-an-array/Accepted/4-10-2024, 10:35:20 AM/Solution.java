// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int len = arr.length;
        int[] res = new int[len];

        int r = 1;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        for(int k : map.keySet()){

            List<Integer> idxs = map.get(k);
            for(int idx : idxs){
                res[idx] = r;
            }
            r++;
        }

        return res;
        
    }
}