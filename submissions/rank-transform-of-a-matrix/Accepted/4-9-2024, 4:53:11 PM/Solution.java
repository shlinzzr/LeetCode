// https://leetcode.com/problems/rank-transform-of-a-matrix

class Solution {

    int[] parent;
    // List<Integer>[] arr;
    Map<Integer, List<int[]>> map =new TreeMap<>();
    public int[][] matrixRankTransform(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        // arr = new ArrayList<>[m*n];
        // parent = new int[m*n];
        // for(int i=0; i<m*n; i++){
        //     parent[i] = i;
        //     arr[i] = new ArrayList<>();
        // }
        

        int[][] res = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map.putIfAbsent(matrix[i][j], new ArrayList<>());
                map.get(matrix[i][j]).add(new int[]{i, j});
            }
        }


        int[] rowMin = new int[h];
        int[] colMin = new int[w];

         for(Integer key : map.keySet()){
            List<int[]> list = map.get(key);
            
            // SPLIT TO GROUPS USING UNION FIND FOR VALs IN SAME COL/ROW
            int siz = list.size();
            parent = new int[siz];
            for(int i = 0; i < siz; i++)
                parent[i] = i;
            
            // Group the xy by col and row then union by row & by col
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for(int i = 0; i < siz; i++){
                int[] yx = list.get(i);
                int y = yx[0];
                int x = yx[1];
                
                yMap.putIfAbsent(y, new ArrayList<>());
                yMap.get(y).add(i);
                xMap.putIfAbsent(x, new ArrayList<>());
                xMap.get(x).add(i);
                
            }
            
            // union by X
            for(Integer xKey : xMap.keySet()){
                List<Integer> xList = xMap.get(xKey);
                for(int i = 1; i < xList.size(); i++){
                    union(xList.get(i-1), xList.get(i));
                }
            }
            
            
            // union by Y
            for(Integer yKey : yMap.keySet()){
                List<Integer> yList = yMap.get(yKey);
                for(int i = 1; i < yList.size(); i++){
                    union(yList.get(i-1), yList.get(i));
                }
            }
            
            HashMap<Integer, List<int[]>> group = new HashMap<>();
            for(int i = 0; i < siz; i++){
                int grp = find(i);
                if(group.get(grp) == null)
                    group.put(grp, new ArrayList<>());
                group.get(grp).add(list.get(i));
            }
            
            
            // SET ANSWER FOR EACH GROUP
            for(Integer grpKey : group.keySet()){
                int max = 1;
                List<int[]> sublist = group.get(grpKey);
                
                // FIND MAX-RANK FOR THIS GROUP
                for(int[] yx : sublist){
                   int y = yx[0];
                   int x = yx[1];
                
                    max = Math.max(max, Math.max(rowMin[y], colMin[x]));
                }
            
                // UPDATE ANSWER = MAX-RANK AND SET NEW MIN-RANK FOR ROW/COL = MAX-RANK+1
                for(int[] yx : sublist){
                    int y = yx[0];
                    int x = yx[1];
                    res[y][x] = max;
                    rowMin[y] = max+1;
                    colMin[x] = max+1;
                }     
            }
        }
        return res;
    }
    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union (int a , int b){
        a = find(a);
        b = find(b);
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}