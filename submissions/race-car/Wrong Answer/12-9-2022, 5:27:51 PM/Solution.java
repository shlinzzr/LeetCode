// https://leetcode.com/problems/race-car

class Solution {
    public int racecar(int target) {
        //AAR.  0 --> 1 --> 3 --> 3
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        Set<String> set = new HashSet<>();
        set.add(0+" "+1);
        
        for(int level=0; !queue.isEmpty(); level++){
            
            for(int k=queue.size(); k>0; k--){
                
                int[] cur = queue.poll();
                if(cur[0]==target){
                    return level;
                }
                
                int[] aaa = new int[]{cur[0]+cur[1], cur[1]<<1};
                String key = (aaa[0] + " " + aaa[1]);
                
                // int[] rrr = new int[]{cur[0], cur[1]>0? -1 : 1 };
                // queue.offer(rrr);
                
                if(!set.contains(key) && aaa[0]>0 &&  aaa[0]<(target<<1)){
                    set.add(key);
                    queue.offer(aaa);
                }
                
            }
            
            
        }
        
        
        return -1;
    
        
        
    }
}