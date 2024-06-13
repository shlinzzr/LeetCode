// https://leetcode.com/problems/minimize-manhattan-distances

class Solution {
    public int minimumDistance(int[][] points) {
        
        
        Arrays.sort(points, (a,b) -> a[0]+a[1]-b[0]-b[1]);
        int len = points.length;
        
        // for(int[] p :points)
        //     System.out.println(p[0]+" " + p[1]);
        
        return getDis(points[0], points[len-1]);
        
        
        
    }
    
    private int getDis(int[] a, int[] b){
        
        return Math.abs(a[0]-b[0])+  Math.abs(a[1]-b[1]);
    }
}