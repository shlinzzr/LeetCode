// https://leetcode.com/problems/finding-the-number-of-visible-mountains

class Solution {
    public int visibleMountains(int[][] peaks) {
        
        Arrays.sort(peaks, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1]);
        int len = peaks.length;

        int res =0;
        for(int i=0; i<len; i++){
            
        }



    }

    private boolean isContain(int[] p1, int[] p2){

        int h1 = p1[1];
        int x1 = p1[0];
        int l1 = p1[0]-h1;
        int r1 = p1[0]+h1;

        int h2 = p2[1];
        int x2 = p2[0];
        int l2 = p2[0]-h2;
        int r2 = p2[0]+h2;

        return l1<=l2 && r1>=r2;
    }
}