// https://leetcode.com/problems/rank-transform-of-a-matrix

class Solution {

    int[] parent;
    // List<Integer>[] arr;
    Map<Integer, List<int[]>> map =new TreeMap<>();
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // arr = new ArrayList<>[m*n];
        // parent = new int[m*n];
        // for(int i=0; i<m*n; i++){
        //     parent[i] = i;
        //     arr[i] = new ArrayList<>();
        // }
        

        int[][] res = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int[] xy = {i, j};
                int val = matrix[i][j];
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(xy);
            }
        }


        int[] minX = new int[m];
        int[] minY = new int[n];

         for(Integer key : map.keySet()){
            List<int[]> list = map.get(key);
            
            // SPLIT TO GROUPS USING UNION FIND FOR VALs IN SAME COL/ROW
            int lSize = list.size();
            parent = new int[lSize];
            for(int i = 0; i < lSize; i++)
                parent[i] = i;
            
            // Group the xy by col and row then union by row & by col
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for(int i = 0; i < lSize; i++){
                int[] xy = list.get(i);
                int x = xy[0];
                int y = xy[1];
                
                if(xMap.get(x) == null)
                    xMap.put(x, new ArrayList<>());
                if(yMap.get(y) == null)
                    yMap.put(y, new ArrayList<>());
                xMap.get(x).add(i);
                yMap.get(y).add(i);
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
            for(int i = 0; i < lSize; i++){
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
                for(int[] xy : sublist){
                    int x = xy[0];
                    int y = xy[1];
                
                    max = Math.max(max, Math.max(minX[x], minY[y]));
                }
            
                // UPDATE ANSWER = MAX-RANK AND SET NEW MIN-RANK FOR ROW/COL = MAX-RANK+1
                for(int[] xy : sublist){
                    int x = xy[0];
                    int y = xy[1];
                    res[x][y] = max;
                    minX[x] = max+1;
                    minY[y] = max+1;
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