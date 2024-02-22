// https://leetcode.com/problems/image-overlap

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int len = img1.length;
        
        int ans = 0;
        for(int i=-len+1; i<len; i++){
            for(int j=-len+1; j<len; j++){
                ans = Math.max(ans, overlap(img1, img2, i, j));
            }
        }
        return ans;
    }
    
    private int overlap(int[][] img1, int[][] img2, int i_offset, int j_offset){
        
        int len = img1.length;
        
        int ans=0;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                int r = i+i_offset;
                int c = j+j_offset;
                
                if(r<0 || r>=len || c<0 || c>=len)
                    continue;
                
                if(img1[r][c]==1 && img2[i][j]==1)
                    ans++;
            }
        }
        
        return ans;
        
        
    }
        
}