// https://leetcode.com/problems/triangle

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
        
//         int len = triangle.size();
//         int[] dp = new int[len];
        
//         // for(List<Integer> list : triangle){
//         for(int i=0; i<triangle.size(); i++){
            
//             List<Integer> list = triangle.get(i);
            
            
//             int min = Integer.MAX_VALUE;
            
//             for(Integer val : list){
//                 if(min>val)
//                     min = val;
//             }
            
//             if(i==0)
//                 dp[0] = min;
//             else{
//                 dp[i] = dp[i-1]+min;
//             }
            
//             System.out.println(dp[i]);
            
            
//         }
//         return dp[len-1];
//     }
// }

public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}