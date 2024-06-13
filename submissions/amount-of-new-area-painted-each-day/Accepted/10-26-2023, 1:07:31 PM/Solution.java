// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        
        int len = paint.length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // x, List<p>,   p ={paint idx, isStart}

        for(int i=0; i<len; i++){
            int[] p = paint[i];
            map.putIfAbsent(p[0], new ArrayList<>());
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[0]).add( new int[]{i, 1});   //  p ={paint idx, isStart}
            map.get(p[1]).add( new int[]{i, -1});
        }

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();

        int[] res = new int[len];

        List<Integer> keyList = new ArrayList<>(map.keySet());

        for(int i=0; i<keyList.size()-1; i++){ // x from left to right, ignore the last point 

            int x = keyList.get(i);
            List<int[]> list = map.get(x);
            for(int[] p : list){
                int idx = p[0];
                int isStart = p[1];

                if(isStart==1){
                    cntMap.put(idx, cntMap.getOrDefault(idx,0)+1);
                }else{
                   cntMap.put(idx, cntMap.getOrDefault(idx,0)-1);
                   if(cntMap.get(idx)==0)
                       cntMap.remove(idx);
                }
            }

            if(!cntMap.isEmpty() ){ // add res when isStart
                res[cntMap.firstKey()] += map.higherKey(x)-x;
            }
        }
        return res;
    }
}