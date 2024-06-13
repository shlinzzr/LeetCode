// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()-b.getValue()
        );

        pq.addAll(map.entrySet());

        while(k>0){

            if(k>=pq.peek().getValue()){
                k-=pq.poll().getValue();
            }else{
                k=0;
            }
        }

        return pq.size();
    }

}