// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();

        Map<String , Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()!=b.getValue() ? a.getValue()-b.getValue() : b.getKey().compareTo(a.getKey())
        );

        for(String w : words){
            map.put(w, map.getOrDefault(w,0)+1);
        }

        pq.addAll(map.entrySet());

        while(pq.size()>k){
            pq.poll();
        }

        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }

        return res;

        
        
        
    }
}