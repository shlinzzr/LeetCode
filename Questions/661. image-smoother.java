// https://leetcode.com/problems/image-smoother

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int h = img.length;
        int w = img[0].length;
        

        int[][] res= new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                smooth(img, i, j, res);
            }
        }
        return res;
    }

    private void smooth(int[][] img, int r, int c, int[][]res){
        int sum = 0 ;

        int h = img.length;
        int w = img[0].length;
        int cnt = 0 ;
        for(int i=Math.max(r-1, 0); i<=Math.min(r+1, h-1); i++){
            for(int j=Math.max(c-1, 0); j<=Math.min(c+1, w-1); j++){
                sum+=img[i][j];
                cnt++;
            }
        }

        // System.out.println(sum + " " +cnt);
        res[r][c] = sum/cnt;
    }
}