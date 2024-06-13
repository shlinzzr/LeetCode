// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]  // val, i, j
        );
        
        // only add len1 個, nums2 add by dynamic
        for(int i=0; i<nums1.length; i++){ 
            pq.offer(new int[]{nums1[i]+nums2[0], i, 0});
        }
        

        while(!pq.isEmpty() && k>0){
            
            int[] p = pq.poll();
            int val = p[0];
            int i = p[1];
            int j = p[2];
            
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            res.add(list);
            
            if(j+1<nums2.length){
                pq.offer(new int[]{nums1[i]+nums2[j+1], i, j+1});
            }
            
            k--;
        }
        
        return res;
        
        
    }
}