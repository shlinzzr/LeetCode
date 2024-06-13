// https://leetcode.com/problems/best-meeting-point

class Solution {
    public int minTotalDistance(int[][] grid) {
        int h= grid.length;
        int w = grid[0].length;

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==1){
                    xList.add(j);
                    yList.add(i);
                    list.add(new int[]{i, j});
                }
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);
        int x = xList.get(xList.size()/2);
        int y = yList.get(yList.size()/2);

        int res = 0;
        for(int[] p : list){
            res += Math.abs(p[0]-y) + Math.abs(p[1]-x);
        }

        return res;
    }
}