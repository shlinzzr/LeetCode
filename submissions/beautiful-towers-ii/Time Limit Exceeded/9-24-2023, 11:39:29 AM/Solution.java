// https://leetcode.com/problems/beautiful-towers-ii

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int len = maxHeights.size();
        
        long res =0;
        for(int i=0; i<len; i++){
            long sum = maxHeights.get(i);
            
            int max= maxHeights.get(i);
            for(int st=i-1; st>=0; st--){
                int val = Math.min(max, maxHeights.get(st));
                sum += val;
                max = Math.min(max, val);
            }
            
            max= maxHeights.get(i);
            for(int ed=i+1; ed<len; ed++){
                int val = Math.min(max, maxHeights.get(ed));
                sum += val;
                max = Math.min(max, val);
            }
            
            res = Math.max(sum , res);
       
        }
        
        return res;
        
    }
}