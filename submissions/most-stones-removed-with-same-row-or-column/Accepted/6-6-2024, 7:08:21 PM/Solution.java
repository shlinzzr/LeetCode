// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {

    Map<Integer, Integer> map;
    Map<Integer, Integer> weight;

    public int removeStones(int[][] stones) {

        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();

        int h=0, w=0;
        for(int[] s : stones){
            int x = s[0];
            int y = s[1];
            w = Math.max(w, x); 
            h = Math.max(h, y); 
            
            row.putIfAbsent(y, new ArrayList<>());
            row.get(y).add(x);

            col.putIfAbsent(x, new ArrayList<>());
            col.get(x).add(y);
        }
        h++; w++;

        map = new HashMap<>();
        int cnt= 0 ;
        for(int r: row.keySet()){
            List<Integer> listx = row.get(r);
            int root = -1;
            for(int x : listx){
                int idx = r*w+x;
                if(root==-1) root = idx;
                  if(union(idx, root)){
                    cnt++;
                }
            }
        }

        for(int c: col.keySet()){
            List<Integer> listy = col.get(c);
            int root = -1;
            for(int y : listy){
                int idx = y*w+c;
                if(root==-1) root = idx;

                if(union(idx, root)){
                    cnt++;
                }
            }
        }


        // 
        // for(int k : map.keySet()){
        //     if(map.get(k)!=k){
        //         cnt++;
        //     }
        // }

        System.out.println(map);

        return cnt;

        
        
        
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

        if(map.get(x)==null){
            map.put(x, x);
        }

        if(map.get(x)!=x) map.put(x, find(map.get(x)));
        return map.get(x);
    }
}

