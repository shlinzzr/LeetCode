// https://leetcode.com/problems/minimum-jumps-to-reach-home

class Solution {
    public int minimumJumps(int[] f, int a, int b, int x) {
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<f.length; i++){
            seen.add(f[i]);
        }

        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        seen.add(0);
        while(!q.isEmpty()){

            int siz = q.size();
            while(siz-->0){
                int[] p = q.poll();

                if(p[0]>2000000) return -1;

                if(p[0]==x) return step;

                if(!seen.contains(p[0]+a)){
                    //  if(p[0]+a==x) return step-1;
                     seen.add(p[0]+a);
                     q.offer(new int[]{p[0]+a, 0});
                }
                    

                if(p[1]==0 && p[0]-b>0 && !seen.contains(p[0]-b)){
                    // if(p[0]-b==x) return step-1;
                    seen.add(p[0]-b);
                    q.offer(new int[]{p[0]-b, 1});
                }
            }
            
            step ++;
        }
        return -1;
    }
}