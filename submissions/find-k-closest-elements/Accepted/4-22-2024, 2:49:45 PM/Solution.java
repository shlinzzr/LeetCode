// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);


        for(int i=0; i<arr.length; i++){
            pq.offer(new int[]{Math.abs(arr[i]-x), arr[i]});
            if(pq.size()>k) pq.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[1]);
        }

        Collections.sort(res);

        return res;
    }
}