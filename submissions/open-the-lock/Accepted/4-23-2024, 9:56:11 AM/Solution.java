// https://leetcode.com/problems/open-the-lock

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000")) return -1;
        return bfs(target, dead);
    }

    private int bfs(String target, Set<String> seen){

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        seen.add("0000");

        int step = 0;
        while(!q.isEmpty()){

            int siz = q.size();
            while(siz-->0){
                
                String p = q.poll();

                if(target.equals(p)) return step;

                char[] arr = p.toCharArray();
                for(int i=0; i<4; i++){

                    char ch = p.charAt(i);

                    char plus =  (char) (((int)(ch-'0')+1)%10 + '0');
                    arr[i] = plus;
                    if(seen.add(new String(arr))){
                        q.offer(new String(arr));
                    }
                    
                    char minus = (char) (((int)(ch-'0')+9)%10 + '0');
                    arr[i] = minus;
                    if(seen.add(new String(arr))){
                        q.offer(new String(arr));
                    }

                    arr[i] = ch;
                }
            }
            step++;
        }
        return -1;
    }
}