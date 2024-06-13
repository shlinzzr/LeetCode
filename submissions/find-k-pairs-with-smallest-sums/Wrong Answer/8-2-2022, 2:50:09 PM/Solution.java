// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) 
            return res;
        
        int m = nums1.length, n = nums2.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        
        for(int j=0; j<nums2.length; j++){
            pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        }
        
        
        
        for(int i=0; i<Math.min(k, m*n); i++){
            Tuple tuple = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[tuple.x]);
            list.add(nums2[tuple.y]);
            res.add(list);
            
            if(tuple.x==m-1)
                continue;
            pq.offer(new Tuple(tuple.x+1, tuple.y, nums1[tuple.x+1]+nums2[tuple.y]));
            
            
        }
        
        return res;
        
        
        
        
    }
}

class Tuple implements Comparable<Tuple>{
    
    int x, y, xval, yval, val;
    public Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that){
        return this.val - that.val;
    }
    
    
    
}