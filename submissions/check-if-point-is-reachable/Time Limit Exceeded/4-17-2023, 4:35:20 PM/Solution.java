// https://leetcode.com/problems/check-if-point-is-reachable

class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        if(targetX==1 && targetY==1)
            return true;
        
        
        Queue<int[]> q= new LinkedList<>();
        
        q.offer(new int[]{1,1});
        HashSet<String> set = new HashSet<>();
        set.add("1-1");
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            List<int[]> list = gen(p);
            boolean allSeen=true;
            
            for(int[] next : list){
                System.out.println(next[0] + " " + next[1]);
                if(next[0]==targetX && next[1]==targetY)
                    return true;
                
                if(set.contains(next[0] + "-" + next[1])){
                    continue;
                }else{
                    allSeen = false;
                    set.add(next[0] + "-" + next[1]);
                    q.offer(next);
                }
            }
            if(allSeen && q.isEmpty())
                return false;
        }
        
        return false;
        
        
        
    }
    
    private List<int[]> gen(int[] p){
        
        List<int[]> list = new ArrayList<>();
        
        int x = p[0];
        int y = p[1];
        
        list.add(new int[]{x, y-x});
        list.add(new int[]{x-y, y});
        list.add(new int[]{2*x, y});
        list.add(new int[]{x, 2*y});
        
        return list;
    }
    
}