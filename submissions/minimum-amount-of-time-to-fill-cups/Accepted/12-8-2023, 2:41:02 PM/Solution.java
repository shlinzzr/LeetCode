// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups

class Solution {
    public int fillCups(int[] amount) {
        int len = amount.length;
        HashMap<String, Integer> map = new HashMap<>();
        if(amount[0]!=0) map.put("cold", amount[0]);
        if(amount[1]!=0) map.put("warm", amount[1]);
        if(amount[2]!=0) map.put("hot", amount[2]);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b)-> b.getValue()-a.getValue()
        );

        pq.addAll(map.entrySet());

        int res= 0;

        while(!pq.isEmpty()){

            if(pq.size()==1){
                res+=pq.peek().getValue();
                return res;
            }else{
                Map.Entry<String, Integer> x = pq.poll();
                Map.Entry<String, Integer> y = pq.poll();

                // int k = x.getValue()==y.getValue() ? 1 : 2;
                x.setValue(x.getValue()-1);
                y.setValue(y.getValue()-1);
                res++;
                if(x.getValue()>0) pq.offer(x);
                if(y.getValue()>0) pq.offer(y);
            }
        }

        return res;
    }
}