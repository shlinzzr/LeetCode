// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int res = 0 ;
        
        for (int i=0; i<h; i++)
        {
            int[] row = new int[w];
            
            for (int r=i; r<h; r++)
            {
                for (int j=0; j<w; j++)
                    row[j] += matrix[r][j];
                
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                
                int presum = 0;
                for (int j=0; j<w; j++)
                {
                    presum += row[j];
                    res += map.getOrDefault(presum-target, 0);
                    map.put(presum, map.getOrDefault(presum, 0)+1);
                }
            }            
        }
        return res;
        
    }
        
        
        
       
        
//         long res =0 ;
        
        
//         int[][] presum = new int[h][w];
//         presum[0][0] = matrix[0][0];
//         map.put(presum[0][0], 1);
        
        
//         HashMap<Integer, Integer> rowMap = new HashMap<>();
//         rowMap.put(0,1);
//         for(int i=1; i<h; i++){
//             presum[i][0] = presum[i-1][0] + matrix[i][0];
//             res += rowMap.getOrDefault(presum[i][0]-target, 0);
//             rowMap.put(presum[i][0], rowMap.getOrDefault(presum[i][0], 0)+1);
//         }
        
        
//         HashMap<Integer, Integer> colMap = new HashMap<>();
//         colMap.put(0,1);
//         for(int j=1; j<w; j++){
//             presum[0][j] = presum[0][j-1] + matrix[0][j];
//             res += colMap.getOrDefault(presum[0][j]-target, 0);
//             colMap.put(presum[0][j], colMap.getOrDefault(presum[0][j], 0)+1);
//         }
        
//         for(Map.Entry<Integer,Integer> en : rowMap.entrySet()){
//             map.put(en.getKey(), en.getValue());
//         }
        
//         for(Map.Entry<Integer,Integer> en : colMap.entrySet()){
//             map.put(en.getKey(), en.getValue());
//         }
//          map.put(0,1);
        
        
//         for(int i=1; i<h; i++){
//             for(int j=1; j<w; j++){
                
//                 presum[i][j] = matrix[i][j] + presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1];
//                 int key = presum[i][j]-presum[i-1][j]-presum[i][j-1]+presum[i-1][j-1]-target;
                    
//                     System.out.println("jey="+key + " "  + map.get(key));
                    
//                 res += map.getOrDefault(key, 0);
                
//                 map.put(presum[i][j], map.getOrDefault(presum[i][j], 0)+1);
//             }
//         }
        
//          for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
//                 System.out.print(presum[i][j] + ",");
//             }
//               System.out.println();
//          }
        // return (int)res;
}