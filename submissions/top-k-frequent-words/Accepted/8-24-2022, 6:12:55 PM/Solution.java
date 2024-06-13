// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: words){
            int c = map.getOrDefault(s, 0);
            map.put(s, c+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            pq.offer(en);
            
            if(pq.size()>k)
                pq.poll();
            
        }
        
        
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add( 0, pq.poll().getKey());
        }
        
        
        
        return list;
        
        
        
        
    }
}