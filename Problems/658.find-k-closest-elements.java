// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->(Math.abs(arr[a]-x)==Math.abs(arr[b]-x)) ? 
                   b-a : 
                   (Math.abs(arr[b]-x)-Math.abs(arr[a]-x))
            );

        for(int i=0; i<arr.length; i++){
            pq.offer( i );
            if(pq.size()>k) pq.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(arr[pq.poll()]);
        }

        Collections.sort(res);

        return res;
    }
}