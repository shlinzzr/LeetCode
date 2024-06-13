// https://leetcode.com/problems/open-the-lock

class Solution {
    public int openLock(String[] deadends, String target) {
        
        // Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        
        
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        
        int step=0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=size; j>0; j--){
                
                String p = q.poll();
                if(deads.contains(p)) {
                    continue;
                }
               
                if(p.equals(target)) return step;
                   StringBuilder sb = new StringBuilder(p);
                for(int i=0; i<4; i++){
                  
                    char ch = p.charAt(i);

//                     String up = p.substring(0, i) + (char)((ch-'0'+1)%10 +'0') + p.substring(i+1);
//                     if(!visited.contains(up)&&!deads.contains(up)){
//                         q.offer(up);
//                         visited.add(up);
//                     }


//                     String down = p.substring(0, i) + (char)((ch-'0'+9)%10 +'0') + p.substring(i+1);
//                     if(!visited.contains(down)&&!deads.contains(down)){
//                         visited.add(down);
//                         q.offer(down);
//                     }
                      String s1 = sb.substring(0, i) + (ch == '9' ? 0 : ch- '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + sb.substring(i + 1);
                    if(!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }

                }

            }
          
            step++;
        }
        return -1;
    }
}