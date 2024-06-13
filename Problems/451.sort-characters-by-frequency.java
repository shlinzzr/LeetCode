// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (e1, e2) -> e2.getValue()-e1.getValue()
        );
        
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            pq.offer(en);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> en  = pq.poll();
            for(int i=0; i<en.getValue(); i++){
                sb.append(en.getKey());    
            }
        }
        
        return sb.toString();
        
    }
}