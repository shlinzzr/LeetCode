// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>  res = new ArrayList<>();
        
        PriorityQueue<Tuple> pq =new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );
        
        
        for(int i=0; i<nums1.length; i++){
            pq.offer(new Tuple(i, 0, nums1[i] + nums2[0]));
        }
        
        
        while(!pq.isEmpty() && k>0){
            
            Tuple p = pq.poll();
            
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p.i]);
            list.add(nums2[p.j]);
            res.add(list);
            
            if(p.j+1==nums2.length)
                continue;
        
            pq.offer(new Tuple(p.i, p.j+1, nums1[p.i] + nums2[p.j+1]));
            k--;
        }
        
        return res;
        
        
            
            
            
            
        
        
        
    }
    
    
    class Tuple{
        
        int i;
        int j;
        int val;
        public Tuple(int i, int j, int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
}