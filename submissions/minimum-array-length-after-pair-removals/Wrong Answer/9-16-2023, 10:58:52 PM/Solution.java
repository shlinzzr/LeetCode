// https://leetcode.com/problems/minimum-array-length-after-pair-removals

class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int len = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b)-> b.getValue()-a.getValue()
        );
        pq.addAll(map.entrySet());
        
        
        while(pq.size()>=2){
            Map.Entry<Integer, Integer> en1 = pq.poll();
            Map.Entry<Integer, Integer> en2 = pq.poll();
            
            if(en1.getValue()==en2.getValue()){
                continue;
            }else if(en1.getValue()>en2.getValue()){
                en1.setValue(en1.getValue()-en2.getValue());
                pq.offer(en1);
                
            }else if(en2.getValue()>en1.getValue()){
                en2.setValue(en2.getValue()-en1.getValue());
                pq.offer(en2);
            }
        }
        
        if(pq.size()==0)
            return 0;
        
        return pq.peek().getValue();
    }
}