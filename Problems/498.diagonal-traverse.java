// https://leetcode.com/problems/diagonal-traverse

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        
        int idx = 0;
        int[] res = new int[h*w];
        
        int[] cur = new int[]{0,0};
        while(idx<h*w){
            
            // go up-right
            for(int i=cur[0], j=cur[1]; i>=0&& j<w; i--,j++){
                res[idx++] = mat[i][j];
                cur[0] = i;
                cur[1] = j;
            }
            
            // test go right, if cant, go down
            if(cur[1]+1<w) cur[1]++;
            else if(cur[0]+1<h) cur[0]++;
            else break;
            
            // go down-left;
            for(int i=cur[0],j=cur[1]; i<h&&j>=0; i++, j--){
                res[idx++] = mat[i][j];
                cur[0]=i;
                cur[1]=j;
            }
            
             // test go down, if cant, go right
            if(cur[0]+1<h) cur[0]++;
            else if(cur[1]+1<w) cur[1]++;
            else break;
            
            
            
        }
        
        return res;
        
        
    }
}