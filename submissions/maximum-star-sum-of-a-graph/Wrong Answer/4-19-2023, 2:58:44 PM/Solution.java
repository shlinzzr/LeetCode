// https://leetcode.com/problems/maximum-star-sum-of-a-graph

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<vals.length; i++){
            max = Math.max(max, vals[i]);
        }
        
        
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int kk =k;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<Integer> list = en.getValue();
            for(int idx : list){
                pq.offer(vals[idx]);
                
                if(pq.size()>k)
                    pq.poll();
            }
            
            int sum =0;
            for(int p : pq){
                sum+=p;
            }
            
            // System.out.println(en.getKey()+  " " + sum);
            
            max = Math.max(max, sum+vals[en.getKey()]);
            
        }
        return max;
        
    }
}