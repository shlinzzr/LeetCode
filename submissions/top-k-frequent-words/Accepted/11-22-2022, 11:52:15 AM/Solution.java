// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) +1 );
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
           (a, b) -> (a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : Integer.compare(a.getValue(), b.getValue()))
        );
        
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            pq.offer(en);
            if(pq.size()>k)
                pq.poll();
        }
        
        
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        
        return res;
        
        
        
    }
}