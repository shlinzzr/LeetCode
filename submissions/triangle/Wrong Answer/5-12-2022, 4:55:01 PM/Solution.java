// https://leetcode.com/problems/triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int[] dp = new int[len];
        
        // for(List<Integer> list : triangle){
        for(int i=0; i<triangle.size(); i++){
            
            List<Integer> list = triangle.get(i);
            
            
            int min = Integer.MAX_VALUE;
            
            for(Integer val : list){
                if(min>val)
                    min = val;
            }
            
            if(i==0)
                dp[0] = min;
            else{
                dp[i] = dp[i-1]+min;
            }
            
            System.out.println(dp[i]);
            
            
        }
        return dp[len-1];
    }
}