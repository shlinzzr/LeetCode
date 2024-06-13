// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Math.abs(a-x)==Math.abs(b-x) ? b-a : Math.abs(b-x) - Math.abs(a-x)
        );
        
        for(int a : arr){
            pq.offer(a);
            if(pq.size()>k)
                pq.poll();
        }
        
        for(int p : pq){
            res.add(p);
        }
        
        Collections.sort(res);
        return res;
    }
}