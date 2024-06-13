// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) +1 );
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() == a.getValue()? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
        );
        
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            pq.offer(en);
            if(pq.size()>2)
                pq.poll();
        }
        
        List<String> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> en : pq){
             list.add(en.getKey());   
        }
        
        return list;
        
        
        
    }
}