// https://leetcode.com/problems/distant-barcodes

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b) -> (b.getValue()-a.getValue())
        );

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int b : barcodes){
            map.put(b, map.getOrDefault(b,0)+1);
        }        

        pq.addAll(map.entrySet());

        int[] res = new int[barcodes.length];
        int idx =0 ;
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        while(!pq.isEmpty()){

            Map.Entry<Integer, Integer> en = pq.poll();
            res[idx++] = en.getKey();
            en.setValue(en.getValue()-1);
            q.offer(en);

            if(q.size()<2)
                continue;

            Map.Entry<Integer, Integer> p = q.poll();
            if(p.getValue()>0){
                pq.offer(p);
            }
        }

        return res;
    }
}