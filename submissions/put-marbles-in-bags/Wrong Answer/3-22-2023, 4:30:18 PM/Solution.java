// https://leetcode.com/problems/put-marbles-in-bags

class Solution {
    public long putMarbles(int[] weights, int k) {
        
        // ref : https://www.youtube.com/watch?v=oUqYGAg9Mkg
        
        int len = weights.length;
        
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len-1; i++){
            
            list.add(weights[i] + weights[i+1]);
        }
        
        Collections.sort(list);
        
        int res = 0;
        for(int i=0; i<k-1; i++){
            res+= list.get(list.size()-i-1);
        }
        for(int i=0; i<k-1; i++){
            res-= list.get(i);
        }
        
      
        
        return res;
        
        
        
    }
}