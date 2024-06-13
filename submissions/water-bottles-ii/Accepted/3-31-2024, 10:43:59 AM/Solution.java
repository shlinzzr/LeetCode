// https://leetcode.com/problems/water-bottles-ii

class Solution {
    public int maxBottlesDrunk(int full, int ex) {
        
        int res = full;
        int empty = full;
        full=0;
        // Queue<int[]> q = new LinkedList<>();
        
        // q.offer(new int[]{full, empty, ex});
        
        while(full!=0 || empty>=ex){
            
            // int [] p = q.poll();
            // int f = p[0];
            
            empty+= full;
            res += full;
            full=0;
            
            while(empty >= ex){
                empty-=ex;
                full++;
                ex++;
            }
            
        }
        
        return res;
        
    }
}