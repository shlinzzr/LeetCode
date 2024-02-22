// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        int max = Integer.MIN_VALUE;
        
        
        if(h<w){
            
            int[][] mat = new int[w][h];
            for(int i=0;i<h; i++){
                for(int j=0; j<w; j++){
                    mat[j][i]=matrix[i][j];
                }
            }
            return maxSumSubmatrix(mat, k);
        }
        
        
     
        for(int i=0; i<h; i++){
            
            int[] row = new int[w];
            for(int r=i; r<h; r++){
                
                for(int j=0;j<w; j++){
                    row[j]+=matrix[r][j];
                }
                
                max = Math.max(max, helper(row, k));
            }
        }
        
        return max;
    }
    
    private int helper(int[] row, int k){
        
        int w = row.length;
        int presum=0;
        
        // x x x [x x x x x] 
        //.    i          j
        //        ^^^^^^^^^ no larger than k
        //       |-> set.ceiling
        // ^^^^^^^^^^ : val
        // presum[j] - presum[i]<=k
        
        int max = Integer.MIN_VALUE;
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int j=0; j<w; j++){
            
            presum += row[j];
            
            Integer val = set.ceiling(presum-k);
            if(val!=null){
                max = Math.max(max, presum-val);
            }
            
            set.add(presum);
        }
        return max;
        
        
        
    }
}