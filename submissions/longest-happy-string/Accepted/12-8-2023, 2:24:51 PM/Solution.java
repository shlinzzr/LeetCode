// https://leetcode.com/problems/longest-happy-string

class Solution {
    public String longestDiverseString(int a, int b, int c) {
         
        HashMap<Character, Integer> map = new HashMap<>();
        if (a!=0) map.put('a', a);
        if (b!=0) map.put('b', b);
        if (c!=0) map.put('c', c);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (x,y) -> y.getValue()-x.getValue()
        );
        pq.addAll(map.entrySet());


        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
        {
            if (pq.size()==1) 
            {
                int k = Math.min(2, pq.peek().getValue());
                for (int i=0; i<k; i++)                    
                    sb.append(pq.peek().getKey());
                return sb.toString();
            }

            Map.Entry<Character, Integer> x = pq.poll();
            Map.Entry<Character, Integer> y = pq.poll();

            int k = x.getValue()==y.getValue() ? 1 : 2;
            for (int i=0; i<k; i++)
                sb.append(x.getKey());
            sb.append(y.getKey());

            x.setValue(x.getValue()-k);
            y.setValue(y.getValue()-1);

            if (x.getValue()!=0) pq.offer(x);
            if (y.getValue()!=0) pq.offer(y);

            // cout<<ret<<endl;
        }
        return sb.toString();
        
    }
}