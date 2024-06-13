// https://leetcode.com/problems/race-car

class Solution {
    public int racecar(int target) {
        //AAR.  0 --> 1 --> 3 --> 3
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1}); // pos, speed
        Set<String> set = new HashSet<>();
        set.add(0+"_"+1);
        
        for(int step=0; !queue.isEmpty(); step++){
            
            for(int k=queue.size(); k>0; k--){
                
                int[] cur = queue.poll();
                if(cur[0]==target){
                    return step;
                }
                
                // accelerate
                int[] nxt = new int[]{cur[0]+cur[1], cur[1]*=2};
                String key = (nxt[0] + "_" + nxt[1]);
                if(!set.contains(key) && nxt[0]>0 &&  nxt[0]<(target*2)){
                    set.add(key);
                    queue.offer(nxt);
                }
                
                
                //reverse
                nxt = new int[]{cur[0], cur[1]>0? -1 : 1 };
                key = (nxt[0] + "_" + nxt[1]);
                if(!set.contains(key) && nxt[0]>0 &&  nxt[0]<(target*2)){
                    set.add(key);
                    queue.offer(nxt);
                }
            }
        }
        
        return -1;
    }
}