// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        
        int len = paint.length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // x, List<p>,   p ={x1, x2, idx}

        for(int i=0; i<len; i++){

            int[] p = new int[3];
            p[0] = paint[i][0];
            p[1] = paint[i][1];
            p[2] = i;

            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add( p );   //  p ={paint idx, isStart}
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add( p );   //  p ={paint idx, isStart}
        }

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();

        int[] res = new int[len];

        for(int x : map.keySet()){ // x from left to right, ignore the last point 
            List<int[]> list = map.get(x);
            for(int[] p : list){
                int idx = p[2];

                if(p[0]==x){ // if  x is start of the p
                    cntMap.put(idx, cntMap.getOrDefault(idx,0)+1);
                }else{
                    cntMap.put(idx, cntMap.getOrDefault(idx,0)-1);
                    if(cntMap.get(idx)==0)
                        cntMap.remove(idx);
                }
            }

            if(!cntMap.isEmpty() ){ 
                res[cntMap.firstKey()] += map.higherKey(x)-x;
            }
        }
        return res;
    }
}