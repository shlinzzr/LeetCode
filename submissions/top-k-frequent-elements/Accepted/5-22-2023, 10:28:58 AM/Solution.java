// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );
        
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            pq.offer(new int[]{en.getKey(), en.getValue()});
        }
        
        int[] res = new int[k];
        int i=0;
        while(k>0){
            
            res[i] = pq.poll()[0];
            
            i++;
            k--;
        }
        
        return res;
        
    }
}