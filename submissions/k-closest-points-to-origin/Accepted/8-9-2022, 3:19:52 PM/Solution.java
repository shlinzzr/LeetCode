// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    return Arrays.copyOfRange(points, 0, K);
}
    
//     public int[][] kClosest(int[][] points, int k) {
        
//           int[][] res = new int[k][2];
//         if(points.length==1){
//                 res[0][0] = points[0][0];
//                 res[0][1] = points[0][1];
//             return res;            
//         }
            
        
        
      
        
//         int[] val = new int[points.length];
//         for(int i=0; i<points.length; i++){
            
//             val[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
//               System.out.println("val="+val[i] );
//         }
        
        
//         for(int j=0;j<k; j++ ){
//             int minVal = Integer.MAX_VALUE;
//             for(int i=0; i<val.length-j; i++){
                
                
                
//                 if(val[i]< minVal){
                    
//                     int temp = val[i];
//                     val[i] = val[val.length-j-1];
//                     val[val.length-j-1] = temp;
//                     minVal = temp;
                    
//                       System.out.println(points[i][0] + "   " + points[i][1]);
                    
//                     res[j][0] = points[i][0];
//                     res[j][1] = points[i][1];
                    
//                 }
            
//             }
            
//              System.out.println("loop val:");
//             for(int ii: val){
//                 System.out.print(ii + " ");
//             }
//             System.out.println();
            
            
//         }
        
//         return res;        
        
        
        
//     }
}