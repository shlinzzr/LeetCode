// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    HashMap<Integer, List<Integer>> rows = new HashMap<>();
    HashMap<Integer, List<Integer>> cols = new HashMap<>();
    HashMap<Integer, Integer> map = new HashMap<>();



    public int removeStones(int[][] stones) {
       
        int len = stones.length;

       
        int h= 0;
        int w = 0;

        int cnt = 0;


        for(int i=0; i<len; i++){
            int[] s = stones[i];

            h= Math.max(h, s[0]);
            w= Math.max(w, s[1]);
            cnt++;
            rows.putIfAbsent(s[0], new ArrayList<>());
            cols.putIfAbsent(s[1], new ArrayList<>());
            rows.get(s[0]).add(s[1]);
            cols.get(s[1]).add(s[0]);

        }

        for(int[] s : stones){
            int idx = (s[0]+1)*w+s[1];
            map.put(idx, idx);
        }

        int rm = 0;

        for(int row : rows.keySet()){
            List<Integer> list = rows.get(row);
            int parent = (row+1)*w + list.get(0);
            for(int c : list){
                int idx = (row+1)*w + c;

                if(find(idx)!=find(parent)){
                    union(parent, idx);
                    rm++;
                }
            }
        }

        for(int col : cols.keySet()){
            List<Integer> list = cols.get(col);
            int parent = (list.get(0)+1)*w + col;
            for(int r : list){
                int idx = (r+1)*w + col;
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