// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);    
        }
        
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue()-b.getValue()
        );
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            // System.out.println(en.getKey()+ ", " + en.getValue());
            pq.add(en);
            if(pq.size()>k)
                pq.poll();
        }
        
        int[] res = new int[k];
        
        int i=0;
        while(pq.size()>0){
            res[i] = pq.poll().getKey();
            i++;
        }
        
        
        return res;
        
        
        
    }
}