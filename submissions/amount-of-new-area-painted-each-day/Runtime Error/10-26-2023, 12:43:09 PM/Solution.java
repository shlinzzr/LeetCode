// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        
        int len = paint.length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // x, List<p>

        for(int i=0; i<len; i++){
            int[] p = paint[i];
            map.putIfAbsent(p[0], new ArrayList<>());
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[0]).add( new int[]{i, 1});
            map.get(p[1]).add( new int[]{i, -1});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0] // sort by paint index
        );

        int[] res = new int[len];

        List<Integer> keyList = new ArrayList<>(map.keySet());

        for(int x  : map.keySet()){ // x from left to right
            List<int[]> list = map.get(x);
            for(int[] p : list){
                int idx = p[0];
                int flag = p[1];
                if(p[1]==1){
                    pq.offer(p);
                }else{
                    pq.remove(p);
                }
            }

            if(!pq.isEmpty()){
                res[pq.peek()[0]] += map.higherKey(x)-x;
            }
        }
        return res;
    }
}