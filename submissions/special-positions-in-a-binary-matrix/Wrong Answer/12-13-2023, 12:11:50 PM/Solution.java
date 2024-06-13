// https://leetcode.com/problems/special-positions-in-a-binary-matrix

class Solution {
    public int numSpecial(int[][] mat) {
        int h = mat.length;
        int w= mat[0].length;

        int[] row = new int[h];
        int[] col = new int[w];
        
        int r=0,c=0;
        for(int i=0; i<h; i++){
            int cnt = 0;
            for(int j=0; j<w; j++){
                
                cnt += mat[i][j];
            }
            row[i] = cnt;
            if(cnt==1)
                r++;
        }

        for(int j=0; j<w; j++){
        
            int cnt = 0;
            for(int i=0; i<h; i++){    
                cnt += mat[i][j];
            }
            col[j] = cnt;
            if(cnt==1)
                c++;
        }

        return Math.min(r, c);
    }
}