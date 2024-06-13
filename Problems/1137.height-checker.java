// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        
        int[] freq = new int[101];
        
        int len = heights.length;
        
        for(int i=0; i<len;i++){
            freq[heights[i]]++;
        }
        
        int idx= 0 , res=0;
        
        for(int i=0; i<len ; i++){
            
            while(freq[idx]==0){
                idx++;
            }
            
            if(idx!=heights[i]){
                res++;
            }
            
            freq[idx]--;
            
            
            
            
        }
        
        return res;
        
        
        
        
        
        // O(nlgn)
//         int len = heights.length;
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0; i<len; i++){
//             pq.offer(heights[i]);
//         }
        
//         int res= 0 ;
//         for(int i=0; i<len; i++){
//             if(pq.poll()!= heights[i]){
//                 res++;
//             }
//         }
        
//         return res;
        
    }
}