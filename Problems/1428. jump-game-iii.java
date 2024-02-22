// https://leetcode.com/problems/jump-game-iii

class Solution {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        boolean[] seen = new boolean[len];
        return dfs(arr, seen, start);
    }

    private boolean dfs(int[] arr, boolean[] seen, int i){

        if(arr[i]==0){
            return true;
        }

        int next = i + arr[i];
        int prev = i - arr[i];

        if(next>=0 && next<arr.length && seen[next]==false){
            seen[next]=true;
            boolean rt = dfs(arr, seen, next);
            if(rt) return true;
            seen[next] = false;
        }

        if(prev>=0 && prev<arr.length && seen[prev]==false){
            seen[prev] = true;
            boolean rt = dfs(arr, seen, prev);
            if(rt) return true;
            seen[prev] = false;
        }

        return false;

    }
}