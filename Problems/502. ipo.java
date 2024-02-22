// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int len = capital.length;
        
        PriorityQueue<int[]> cappq = new PriorityQueue<>(
            (a, b) ->Integer.compare(a[1], b[1]) 
        );
        PriorityQueue<int[]> propq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0],a[0])
        );
        
        
        
        
        
        for(int i=0; i<len; i++){
            cappq.offer(new int[]{profits[i], capital[i]});
        }
        
        
        for(int i=0; i<k; i++){
            
            while(!cappq.isEmpty() && cappq.peek()[1]<=w){
                propq.offer(cappq.poll());
            }
            
            if(propq.isEmpty())
                break;
            
            w+=propq.poll()[0];
        }
        
        return w;
        
        
    }
}