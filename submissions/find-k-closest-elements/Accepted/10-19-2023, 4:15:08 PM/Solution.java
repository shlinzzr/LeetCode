// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);

        for(int a: arr){
            pq.offer(new int[]{Math.abs(a-x), a});

            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> res = new ArrayList();
        for(int i=pq.size(); i>0; i--){
            res.add(pq.poll()[1]);
        }

        Collections.sort(res);
        return res;
    }
}