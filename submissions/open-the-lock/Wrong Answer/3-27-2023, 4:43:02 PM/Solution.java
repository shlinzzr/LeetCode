// https://leetcode.com/problems/open-the-lock

class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        set.add("0000");
        
        int step=1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=size; j>=0; j--){
                
                String p = q.poll();

                if(target.equals(p))
                    return step;
                
                
                for(int i=0; i<4; i++){
                    char ch = p.charAt(i);

                    String up = p.substring(0, i) + (char)((ch-'0'+1)%10 +'0') + p.substring(i+1);
                    if(!set.contains(up)){
                        q.offer(up);
                        set.add(up);
                    }


                    String down = p.substring(0, i) + (char)((ch-'0'+9)%10 +'0') + p.substring(i+1);
                    if(!set.contains(down)){
                        set.add(down);
                        q.offer(down);
                    }

                }

            }
          
            step++;
        }
        return -1;
    }
}