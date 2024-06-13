// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {

    Map<Integer, Integer> map;

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


        map = new HashMap<>();

        for(int r: row.keySet()){
            List<Integer> listx = row.get(r);
            int root = -1;
            for(int j=0; j<listx.size();j++){
                int x = listx.get(j);
                int idx = r*w+x;
                if(j==0) root = find(idx);
                map.put(find(idx), root);
            }
        }

        for(int c: col.keySet()){
            List<Integer> listy = col.get(c);
            int root = -1;
            for(int i=0; i<listy.size();i++){
                int y = listy.get(i);
                int idx = y*w+c;
                if(i==0) root = find(idx);
                map.put(find(idx), root);
            }
        }


        int cnt= 0 ;
        for(int k : map.keySet()){
            if(map.get(k)!=k){
                cnt++;
            }
        }

        return cnt;


        

    

        // row = new int[h];
        // col = new int[w];

        // int cnt = 0;
        // for(int i=0; i<h; i++) row[i] = i;
        // for(int j=0; j<w; j++) col[j] = j;

        // for(int i=0; i<h; i++){
        //     int root_x = -1;
        //     for(int j=0; j<w; j++){
        //         if(stones[i][j]==1){
        //             if(root_x==-1){
        //                 root_x=j;
        //             }else{
        //                 if(union(root_x, j, col))
        //                     cnt++;
        //             }
        //         }
        //     }
        // }

        // for(int j=0; j<w; j++){
        //     int root_y = -1;
        //     for(int i=0; i<h; i++){
        //         if(stones[i][j]==1){
        //             if(root_y==-1){
        //                 root_y=i;
        //             }else{
        //                 if( union(root_y, i, row))
        //                     cnt++;
        //             }
        //         }
        //     }
        // }


        // return cnt;
            
        
        
    }



    private int find(int x){

        if(map.get(x)==null){
            map.put(x, x);
        }

        if(map.get(x)!=x) map.put(x, find(map.get(x)));
        return map.get(x);
    }
}

