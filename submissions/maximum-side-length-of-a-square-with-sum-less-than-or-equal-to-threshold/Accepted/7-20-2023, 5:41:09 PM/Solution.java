// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int h = mat.length;
        int w = mat[0].length;
        
        int st =1, ed = Math.min(h,w);
        
        
        int[][] presum = getPresum(mat);
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            boolean bool = isOk(presum, mid, threshold);
            
            // System.out.println(st + " " + ed +" " + mid + " bool="+ bool );
            
            if(bool){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        // System.out.println("quit while loop");
        
        // System.out.println(st + " " + isOk(presum, st-1, threshold) + " " + isOk(presum, st, threshold));
        
        if( isOk(presum, st, threshold)){
            return st;
        }else{
            if(st-1>0 && isOk(presum, st-1, threshold))
                return st-1;
        }
        
        return 0;
        
        
    }
    
    
    private int[][] getPresum(int[][] mat){
        
        int h = mat.length;
        int w = mat[0].length;
        
        int[][] presum = new int[h][w];
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                presum[i][j] = mat[i][j] + (i>0? presum[i-1][j]:0) + (j>0? presum[i][j-1]:0) - (i>0&&j>0? presum[i-1][j-1]:0);
            }
        }
        
        // System.out.println("presum:");
        // for(int i=0; i<h; i++){
        //     for(int j=0; j<w; j++){
        //         System.out.print(presum[i][j] + ",");
        //     }
        //     System.out.println();
        // }
        
        
        return presum;
    }
    
    
    private boolean isOk(int[][] presum, int mid ,int threshold){
        
        int h = presum.length;
        int w = presum[0].length;
        
        // System.out.println("isOk :" + mid);
        
        for(int i=mid-1; i<h; i++){
            for(int j=mid-1; j<w; j++){
                
                int sum = presum[i][j] - (i-mid>0? presum[i-mid][j] : 0) - (j-mid>0? presum[i][j-mid]:0) + (i-mid>0 && j-mid>0 ? presum[i-mid][j-mid] : 0);
                if(sum<=threshold){
                    // System.out.println("isOk :" + mid + " true  sum=" + sum);
                    return true;
                }
                    
            }
        }
        
        // System.out.println("isOk :" + mid + " false");
        return false;
        
        
        
    }
}