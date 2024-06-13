// https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles

class Solution {
    
    
//     class Square {
        
//         int[] bl;
//         int[] tr;
//         int idx;
        
//         public Square(int[] bl, int [] tr, int idx){
//             this.bl=bl;
//             this.tr=tr;
//             this.idx=idx;
//         }
//     }
    
    
    public long largestSquareArea(int[][] bl, int[][] tr) {
        
        // List<Square> list = new ArrayList<>();
         
        int len = bl.length;

//         for(int i=0; i<len; i++){
//             list.add(new Square(bl[i], tr[i], i));
//         }
        
//         Collections.sort(list, (a,b)-> )
        
        
        int max = 0 ;
        
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                int[] bl_a = bl[i];
                int[] tr_a = tr[i];
                
                int[] bl_b = bl[j];
                int[] tr_b = tr[j];
                
             
                int a =  getArea(bl_a, tr_a);
                int b = getArea(bl_b, tr_b);
                
                
                int inter = intersec(bl_a, tr_a, bl_b, tr_b);
                // System.out.println(i + " " + j + " a=" + a + " b="+ b + " inter=" + inter);
                // int area =  a + b - inter;
                max= Math.max(max, inter);

                    
                    
    // (bl[0], tr[1] ) (tr[0], tr[1])
    // (bl[0], bl[1]),  (tr[0], bl[1])
                    
                
            }
        }
    
        return max;
        
    }
    
    
  
    
    private int intersec(int[] bl_a, int[] tr_a, int[] bl_b, int[] tr_b){
        
        
        
         int top = Math.min(tr_a[1], tr_b[1]);
         int bottom = Math.max(bl_a[1], bl_b[1]);
         int left = Math.max(bl_a[0], bl_b[0]);
         int right = Math.min(tr_a[0], tr_b[0]);
                    
        if(top<=bottom) return 0;
        if(right<=left) return 0;
        int intersec =(top-bottom) * (right-left);
        
        
        int sq = Math.min(top-bottom, right-left);
        
        return sq*sq;
           
    }
    
    private int getArea(int[] b, int[] t){
        
        return (t[0]-b[0])* (t[1]-b[1]);
    }
}