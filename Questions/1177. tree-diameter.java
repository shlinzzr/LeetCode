// https://leetcode.com/problems/tree-diameter

class Solution {

    int max =1;
    public int treeDiameter(int[][] edges) {
        int len = edges.length;
        int n = len+1;
        if(len==0)
            return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        
        getDepth(-1, 0, map);

        return max;

    }

    private int getDepth(int parent , int root, HashMap<Integer, List<Integer>> map){

        List<Integer> adjs = map.getOrDefault(root, new ArrayList<>());

        if(adjs.size()==1 && adjs.get(0)==parent)
            return 1;

        int max1 = 0; 
        int max2 =0;

        for(int adj : adjs){

            if(adj==parent)
                continue; 

            int d1 = getDepth(root, adj, map);
            if(d1>max1){
                max2 = max1;
                max1 = d1;
            }else if(d1>max2){
                max2=d1;
            }
        }
        max = Math.max(max, max1 + max2);
        // max = Math.max(max, lv + max2+1);
        // max = Math.max(max, max1 + lv+1);

        return max1+1;

    }
}