// https://leetcode.com/problems/jump-game-iii

class Solution {
    public boolean canReach(int[] arr, int start) {

        int len = arr.length;
        boolean[] seen = new boolean[len];
        

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        seen[start] = true;

        while(!q.isEmpty()){
            int p = q.poll();
            int v = arr[p];
            if(v==0) return true;

            
            if(p+v>=0 && p+v<len && seen[p+v]==false){
                q.offer(p+v);
                seen[p+v]=true;
            }

            if(p-v>=0 && p-v<len && seen[p-v]==false){
                q.offer(p-v);
                seen[p-v]=true;
            }
        }

        return false;

        

        
    }
}