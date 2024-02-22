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
            h= Math.max(h, s[0]+1);
            w= Math.max(w, s[1]+1);
            rows.putIfAbsent(s[0], new ArrayList<>());
            cols.putIfAbsent(s[1], new ArrayList<>());
            rows.get(s[0]).add(s[1]);
            cols.get(s[1]).add(s[0]);
        }


        for(int[] s : stones){
            int idx = s[0]*w + s[1];
            map.put(idx, idx);
        }


        int rm = 0;

        // union by row
        for(int row : rows.keySet()){
            List<Integer> list = rows.get(row);
            int parent = (row)*w + list.get(0);
            for(int c : list){
                int idx = (row)*w + c;

                if(find(idx)!=find(parent)){
                    union(parent, idx);
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
                if(find(idx)!=find(parent)){
                    union(parent, idx);
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


    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b)
            return;

        if(a<b){
            map.put(b, a);
        }else{
            map.put(a, b);
        }
    }

    private int find(int x){
        if(map.get(x)!=x){
            map.put(x, find(map.get(x)));
        }

        return map.get(x);
    }
}