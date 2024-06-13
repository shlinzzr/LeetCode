// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        if(h==0)
            return 0;
        
        if (h>w){
            int[][] mat = new int[w][h];
            for (int i=0; i<h; i++)
                for (int j=0; j<w; j++)
                    mat[j][i]=matrix[i][j];
            return maxSumSubmatrix(mat, k);
        }
        
        
        
        int result = Integer.MIN_VALUE;
        
        for (int i=0; i<h; i++)        
        {
            int[] row = new int[w];
            
            for (int r=i; r<h; r++)
            {
                
                for (int j=0; j<w; j++)
                    row[j]+=matrix[r][j];
                
                result = Math.max(result, getNoLargerThanK(row, k));
            }
        }        
        return result;
    } 
        
/*        
        for (int i=0; i<M; i++)        
        {
            vector<int>row(N,0);
            for (int j=i; j<M; j++)
            {
                for (int k=0; k<N; k++)
                    row[k]+=matrix[j][k];
                result = max(result,helper(row,k));
            }
        }        
        return result;*/
    
    
    private int getNoLargerThanK(int[] row, int k){
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        int presum = 0;
        int result = Integer.MIN_VALUE;;
        
        for (int i=0; i<row.length; i++){
        
            presum+=row[i];
            
            Integer val = set.ceiling(presum-k);
            if (val!=null) 
                result = Math.max(result, presum-val);
            set.add(presum);
        }
        return result;
    }
    
  
}