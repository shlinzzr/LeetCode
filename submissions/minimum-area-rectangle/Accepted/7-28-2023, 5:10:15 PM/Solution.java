// https://leetcode.com/problems/minimum-area-rectangle

class Solution {
    public int minAreaRect(int[][] points) {
        
        // Arrays.sort(points, (a,b)-> a[0]==b[0] ? a[1]-b[1] :  a[0]-b[0]);
        
        int res = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<>();
        
        
        int len = points.length;
        
        
        if(len<4)
            return 0;
        
        for(int i=0; i<len; i++){
            int[] p = points[i];
            set.add(p[0] + "_" + p[1]);
        }
        
        
        for(int[] pt1 : points){
            for(int[] pt2 : points){
                
//                 if(pt1==pt2)
//                     continue;
                
                int p1x = pt1[0];
                int p1y = pt1[1];
                int p2x = pt2[0];
                int p2y = pt2[1];
                
                if(p1x==p2x || p1y==p2y)
                    continue;
                
                String p3 = p1x+"_"+p2y;
                String p4 = p2x+"_"+p1y;
                
                if(set.contains(p3) && set.contains(p4)){
                    int area = Math.abs(p1x-p2x)*Math.abs(p1y-p2y);
                    res = Math.min(res, area);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        return res==Integer.MAX_VALUE ? 0 : res;
    }
    
}