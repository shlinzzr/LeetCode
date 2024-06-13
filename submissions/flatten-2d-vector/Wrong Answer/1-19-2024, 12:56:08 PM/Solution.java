// https://leetcode.com/problems/flatten-2d-vector

class Vector2D {

    int h;
    int i=0,j=0;
    int[][] vec;
        
    public Vector2D(int[][] vec) {
        this.vec= vec;
        this.h= vec.length;
    }
    
    public int next() {
        if(i==h) return -1;
        int val = vec[i][j];
        if(++j==vec[i].length){
            j=0;
            i++;
        }
            
        return val;
        
    }
    
    public boolean hasNext() {
        return i!=h;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */