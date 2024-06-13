// https://leetcode.com/problems/flatten-2d-vector

class Vector2D {
    
    List<Integer> list;
    int curr =0;
    public Vector2D(int[][] vec) {
        list = new ArrayList<>();
        for(int[] arr : vec){
            for(int v : arr)
                list.add(v);
        }
    }
    
    public int next() {
       int val = list.get(curr);
        curr++;
        return val;
    }
    
    public boolean hasNext() {
        // System.out.println(list.size() +" " +curr);
        return curr<list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */