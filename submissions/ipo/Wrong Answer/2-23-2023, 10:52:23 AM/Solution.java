// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int len = capital.length;
        boolean[] seen = new boolean[len];
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
        );
        for(int i=0; i<capital.length; i++){
            int c = capital[i];
            if(c<=w){
                seen[i]=true;
                pq.offer(profits[i]);
            }
        }
        
        int res = w;
        
        while(!pq.isEmpty() && k>0){
            
            int p = pq.poll();
            res+=p;
                
            for(int i=0; i<capital.length; i++){
                int c = capital[i];
                if(c<=p){
                    seen[i]=true;
                    pq.offer(profits[i]);
                }
            }
        
            
            
            
            
            k--;
        }
        return res;
        
        
        
    }
}