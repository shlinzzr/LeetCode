// https://leetcode.com/problems/best-meeting-point

class Solution {
    public int minTotalDistance(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        List<Integer> xlist = new ArrayList<>();
        List<Integer> ylist = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1){
                    xlist.add(j);
                    ylist.add(i);
                    list.add(new int[]{i, j});
                }
            }
        }

        Collections.sort(xlist);
        Collections.sort(ylist);

        int r = ylist.get(ylist.size()/2);
        int c = xlist.get(xlist.size()/2);

        int res= 0 ;

        for(int[] p : list){
            res+= Math.abs(r-p[0]) + Math.abs(c-p[1]);
        }

        return res;
        
    }
}