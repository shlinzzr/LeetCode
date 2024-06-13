// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0]+b[1] -a[0]-a[1]
        );


        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                
                pq.offer(new int[]{nums1[i], nums2[j]});
                if(pq.size()>k)
                    pq.poll();
            }
        }

        for(int[] p : pq){
            List<Integer> list = new ArrayList<>();
            list.add(p[0]);
            list.add(p[1]);

            res.add(0, list);
        }

        return res;
        

    }
}