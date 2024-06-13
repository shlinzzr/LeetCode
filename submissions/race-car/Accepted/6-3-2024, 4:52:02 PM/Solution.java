// https://leetcode.com/problems/race-car

class Solution {
    public int racecar(int target) {
        
        Queue<int[]> q = new LinkedList<>(); // pos, speed
        q.offer(new int[]{0,1});
        Set<String> set = new HashSet<>();
        set.add("0_1");
        
        for(int step=0; !q.isEmpty(); step++){
            
            for(int i=q.size(); i>0; i--){

                int[] p = q.poll();
                int pos = p[0];
                int speed= p[1];

                
                if(pos==target)
                    return step;
                
                // acc
                int[] next = new int[]{pos+ speed, speed*2};
                String key = next[0] + "_"+ next[1];
                if(!set.contains(key) && next[0]>0 && next[0]<target*2){
                    set.add(key);
                    q.offer(next);
                }
                
                // rev
                next = new int[]{pos, speed>0? -1 : 1};
                key = next[0] + "_"+ next[1];
                if(!set.contains(key) && next[0]>0 && next[0]<target*2){
                    set.add(key);
                    q.offer(next);
                }
            }
        }
        return -1;
        
        
    }
}