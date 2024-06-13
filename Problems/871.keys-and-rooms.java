// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> keys = new HashSet<>();
        int n = rooms.size();
        boolean[] seen = new boolean[n];
        seen[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){

            int p = q.poll();
            
            List<Integer> getKeys = rooms.get(p);
            for(int k : getKeys){
                if(seen[k]) continue;
                seen[k] = true;
                q.offer(k);
            }
        }

        for(int i=0; i<n; i++){
            if(seen[i]==false) return false;
        }

        return true;
        
    }
}