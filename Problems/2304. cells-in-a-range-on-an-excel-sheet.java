// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet

// class Solution {
//     public List<String> cellsInRange(String s) {
//         String[] arr = s.split(":");
        
//         String first = arr[0];
//         String last = arr[arr.length-1];
        
//         int rowSize = last.charAt(0)- first.charAt(0);
//         int colSize = last.charAt(1)- first.charAt(1);
        
//         System.out.println(rowSize + " "+colSize);
        
//         List<String> res = new ArrayList<>();
        
//         for(int r=0; r<=rowSize; r++){
//             for(int c=0; c<=colSize;c++){
                
//                 String val =  String.valueOf((char)(first.charAt(0) + r)) +  String.valueOf((char) (first.charAt(1) + c));
                
//                 res.add(val);
                
//             }
            
            
//         }
        
//         return res;
        
        
//     }
// }


class Solution {
    public List<String> cellsInRange(String s) {
       List<String> cellsRange = new ArrayList<>();
        char startColumn = s.charAt(0);
        char endColumn = s.charAt(3);

        char startRow = s.charAt(1);
        char endRow = s.charAt(4);

        for (char column = startColumn; column <= endColumn; column++) {
            for (char row = startRow; row <= endRow; row++) {
                cellsRange.add(new String(new char[]{column, row}));
            }
        }

        return cellsRange;
    }
}