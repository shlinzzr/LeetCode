// https://leetcode.com/problems/sort-the-matrix-diagonally

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        
        int dlen = Math.min(h, w);
        
        // start from left side... (x==0)
        for(int y=0; y<h; y++){
            int x=0;
            List<Integer> list = new ArrayList<>();
            // loop dia to get value
            for(int i=0; i<dlen && y+i<h; i++){
                list.add( mat[y+i][x+i]);
            }
            
            Collections.sort(list);
            
            // set value
            for(int i=0; i<dlen && y+i<h; i++){
                mat[y+i][x+i] = list.get(i);
            }
            
        }
        
        
        // start from top side... (y==0)
        for(int x=0; x<w; x++){
            int y=0;
            List<Integer> list = new ArrayList<>();
            // loop dia to get value
            for(int i=0; i<dlen && x+i<w; i++){
                list.add(mat[y+i][x+i]);
            }
            
             Collections.sort(list);
            
            // set value
            for(int i=0; i<dlen && x+i<w;  i++){
                mat[y+i][x+i] = list.get(i);
            }
            
        }
        
        return mat;
        
        
        
        
        
    }
}