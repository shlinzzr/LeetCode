// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] D, int target) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(D);

        boolean[] seen = new boolean[D.length];

        dfs(res, D, target, new ArrayList<>(), 0, seen);
        return new ArrayList<>(res);
    }

    private void dfs( Set<List<Integer>> res, int[] D, int target, List<Integer> curr, int st, boolean[] seen ){

        if(target==0){
            List<Integer> list = new ArrayList<>(curr);
            // Collections.sort(list);
            res.add(list);
            return;
        }

        for(int i=st; i<D.length; i++){

            if(i>0 && D[i]==D[i-1] && seen[i-1]==false)
                continue;
                
            if(target-D[i]>=0){
                curr.add(D[i]);
                seen[i]=true;
                dfs(res, D, target-D[i], curr, i+1, seen);
                curr.remove(curr.size()-1);
                seen[i]=false;
            }
        }
    }

    
}