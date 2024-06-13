// https://leetcode.com/problems/minimum-jumps-to-reach-home

class Solution {
    public int minimumJumps(int[] f, int a, int b, int x) {

        int  furthest = x + a + b;
        Set<String> seen = new HashSet<>();
        for(int i=0; i<f.length; i++){
            seen.add(f[i]+"_"+1);
            seen.add(f[i]+"_"+0);
             furthest = Math.max(furthest, f[i] + a + b);
        }

        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        seen.add("0_0");
        while(!q.isEmpty()){

            int siz = q.size();
            while(siz-->0){
                int[] p = q.poll();

                if(p[0]>=6000) {
                    return -1;
                }

                if(p[0]==x) return step;

                if(!seen.contains((p[0]+a)+"_0") && p[0]+a<=furthest){
                    //  if(p[0]+a==x) return step-1;
                     seen.add((p[0]+a)+"_0");
                     q.offer(new int[]{p[0]+a, 0});
                }
                    

                if(p[1]==0 && p[0]-b>=0 && !seen.contains((p[0]-b)+"_1")){
                    // if(p[0]-b==x) return step-1;
                    seen.add((p[0]-b)+"_1");
                    q.offer(new int[]{p[0]-b, 1});
                }
            }
            
            step ++;
        }
        return -1;
    }
}