// https://leetcode.com/problems/minimize-manhattan-distances

class Solution {
    public int minimumDistance(int[][] points) {
        
          int len = points.length;
        int[][] t = new int[len][3];
        
        for(int i=0; i<len; i++){
            int[] p = points[i];
            int x = p[0];
            int y = p[1];
            
            int a = x+y;
            int b = x-y;
            
            t[i] = new int[]{a, b, a+b};
            
        }
            
        // Arrays.sort(points, (a,b) -> a[2]-b[2]);
          Arrays.sort(t, (a,b) -> Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]));
      
      
        
        // for(int[] p :points)
        //     System.out.println(p[0]+" " + p[1]);
        
        // return Math.min( getDis(t[1], t[len-1]), 
        //                  getDis(t[0], t[len-2]));
        
        return getDis(t[0], t[len-2]);
        
        
        
    }
    
    private int getDis(int[] a, int[] b){
        
        return Math.abs(a[0]-b[0])+  Math.abs(a[1]-b[1]);
    }
}

/*Input:
[[3,2],[3,9],[7,10],[4,4],[8,10],[2,7]]
Output:
13
Expected:
10*/