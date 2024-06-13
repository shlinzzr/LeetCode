// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        
        int len = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<len; i++){
            pq.offer(heights[i]);
        }
        
        int res= 0 ;
        for(int i=0; i<len; i++){
            if(pq.poll()!= heights[i]){
                res++;
            }
        }
        
        return res;
        
    }
}