// https://leetcode.com/problems/describe-the-painting

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {

        List<List<Long>> res = new ArrayList<>();

        // int[] diff = new int[100001];
        TreeMap<Integer, Integer> dmap = new TreeMap<>(); 
        for(int[] seg : segments){
            // diff[seg[0]]+=seg[2];
            // diff[seg[1]+1]-= seg[2];

            dmap.put(seg[0], dmap.getOrDefault(seg[0],0)+seg[2]);
            dmap.put(seg[1], dmap.getOrDefault(seg[1],0)-seg[2]);
        }

        long prev = -1;
        long cur = 0 ;

        for(int x : dmap.keySet()){
            if(prev!=-1){
                List<Long> list = new ArrayList<>();
                list.add(prev);
                list.add((long)x);
                list.add(cur);
                res.add(new ArrayList<>(list));
            }
            prev = x;
            cur += dmap.get(x);
        }

        return res;



        
    }
}