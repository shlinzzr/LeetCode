// https://leetcode.com/problems/reorganize-string

class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> (b.getValue()-a.getValue())
        );

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }        

        pq.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){

            Map.Entry<Character, Integer> en = pq.poll();
            sb.append(en.getKey());
            en.setValue(en.getValue()-1);
            q.offer(en);

            if(q.size()<2)
                continue;

            Map.Entry<Character, Integer> p = q.poll();
            if(p.getValue()>0){
                pq.offer(p);
            }
        }

        return sb.length()==s.length() ? sb.toString() : "";
    }
}