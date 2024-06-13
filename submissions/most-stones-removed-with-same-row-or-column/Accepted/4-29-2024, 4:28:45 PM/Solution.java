// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    HashMap<Integer, List<Integer>> rows = new HashMap<>();
    HashMap<Integer, List<Integer>> cols = new HashMap<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public int removeStones(int[][] stones) {
       
        int len = stones.length;

       
        int h= 0;
        int w = 0;

        for(int i=0; i<len; i++){
            int[] s = stones[i];
            int r = stones[i][0];
            int c = stones[i][1];
            h= Math.max(h, r+1);
            w= Math.max(w, c+1);
            rows.putIfAbsent(r, new ArrayList<>());
            rows.get(r).add(c);

            cols.putIfAbsent(c, new ArrayList<>());
            cols.get(c).add(r);
        }

        // init parent
        for(int[] s : stones){
            int idx = s[0]*w + s[1];
            map.put(idx, idx);
        }


        int rm = 0;

        // union by row
        for(int row : rows.keySet()){
            List<Integer> list = rows.get(row); // list of cols
            int parent = row * w + list.get(0);
            for(int c : list){
                int idx = (row)*w + c;

                if(union(parent, idx)){
                    rm++;
                }
            }
        }

        // union by col
        for(int col : cols.keySet()){
            List<Integer> list = cols.get(col);
            int parent = (list.get(0))*w + col;
            for(int r : list){
                int idx = (r)*w + col;
                if(union(parent, idx)){
                    rm++;
                }
            }
        }

        return rm;


        /*
        o r x
        r x r
        x r r
        */
    }


    private boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b)
            return false;

        if(a<b){
            map.put(b, a);
        }else{
            map.put(a, b);
        }

        return true;
    }

    private int find(int x){
        if(map.get(x)!=x){
            map.put(x, find(map.get(x)));
        }

        return map.get(x);
    }
}