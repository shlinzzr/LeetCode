// https://leetcode.com/problems/triangle

class Solution {
    
    int min = Integer.MAX_VALUE;
    
//     public int minimumTotal(List<List<Integer>> triangle) {
// 	int rowNum = triangle.size();
// 	int[] dp = new int[rowNum];
// 	for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
// 		dp[i] = triangle.get(rowNum - 1).get(i);
// 	}
// 	for (int row = rowNum - 2; row >= 0; row--) {// for each layer
// 		for (int col = 0; col <= row; col++) {
// 			dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
// 		}
// 	}
    
    
// 	return dp[0];
// }
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        
        int[] dp = new int[len];
        
        // initialize
        for(int j=0;j<len; j++){
            dp[j] = triangle.get(len-1).get(j);
        }    
        
        
        for(int i=len-2; i>=0; i--){
            
            for(int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
        
        
        
        
        
        
        
    }
}