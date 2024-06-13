// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    
    int[] parent;
    int[] weight;
    public int removeStones(int[][] stones) {
        
        int h = stones.length;
        int w = stones[0].length;
        
        
//         Arrays.fill(weight, 1);
//         parent = new int[h*w];
//         for(int i=0; i<h*w; i++){
//             parent[i] = i;
//         }
        Map<Integer, List<int[]>> rowMap = new HashMap<>();
        Map<Integer, List<int[]>> colMap = new HashMap<>();
        
        int[] row = new int[h];
        int[] col = new int[w];
        for(int i=0; i<stones.length; i++){
            
            int r = stones[i][0];
            int c = stones[i][1];
            
            map.putIfAbsent(r, new ArrayList<>());
            map.putIfAbsent(c, new ArrayList<>());
            map.get(r).add(stones[i]);
            map.get(c).add(stones[i]);
            
            row[r]++;
            col[c]++;
        }
        
        boolean[] setRow = new boolean[h];
        boolean[] setCol = new boolean[w];
        for(int i=0; i<row.length; i++){
            if(row[i]==1){
                int[] p = map.get(i).get(0);
                setRow[i] = true;
                setCol[p[1]] = true;
            }
        }
        
        for(int j=0; j<col.length; j++){
            if(col[i]==1){
                int[] p = map.get(j).get(0);
                setCol[j] = true;
                setRow[p[0]] = true;
            }
        }
        
    }
    
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a==b) return ;
        
        if(weight[a]>weight[b]){
            weight[a]+= weight[b];
            parent[b] = a;
        }else{
            weight[b]+= weight[a];
            parent[a] = b;
        }
    }
    
    private int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }