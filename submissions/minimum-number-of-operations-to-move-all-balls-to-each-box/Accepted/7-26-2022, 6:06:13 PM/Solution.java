// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box

class Solution {
    public int[] minOperations(String boxes) {
         int n = boxes.length();
        int[] res = new int[n];
       
        for(int i=0; i<n; i++){
            
            int cnt=0;
            for(int j=0; j<n; j++){
                
                if(i==j)
                    continue;
                
                if(boxes.charAt(j)=='1'){
                    cnt += Math.abs(i-j);
                }
                
                
                
            }
            
            res[i] = cnt;
        }
        
        return res;
    }
    
}