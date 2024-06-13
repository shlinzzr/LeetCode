// https://leetcode.com/problems/valid-arrangement-of-pairs

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int len = pairs.length;
        int[][] res = new int[len][];
      
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<len; i++){
            map.putIfAbsent(pairs[i][0], new ArrayList<>());
            map.get(pairs[i][0]).add(i);
        }

        for(int i=0; i<len; i++){
            boolean[] seen = new boolean[len];
            seen[i]=true;
            if(dfs(pairs, i, map, seen, res, 0)){
                return res;
            }
        }

        return res;
        
    }

    private boolean dfs(int[][] pairs, int i, HashMap<Integer, List<Integer>> map, boolean[] seen ,int[][] res , int idx){

        int len = pairs.length;
       
        
        int[] cur = pairs[i];
        res[idx]=cur;

        if(idx==len-1) return true;

        // for(int[] r : res){
        //     if(r!=null)
        //     System.out.print("{"+r[0]+","+r[1]+"},");
        // }System.out.println();

        for(int next : map.getOrDefault(cur[1], new ArrayList<>())){

            // System.out.println("cur=["+cur[0]+","+cur[1]+ "], next="+next);

            if(seen[next]==false){
                seen[next]=true;
                if(dfs(pairs, next, map, seen, res, idx+1))
                    return true;
                seen[next]=false;
            }
        }

        return false;


    }
}