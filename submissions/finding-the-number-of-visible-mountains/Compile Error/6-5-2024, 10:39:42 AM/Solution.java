// https://leetcode.com/problems/finding-the-number-of-visible-mountains

class Solution {
    public int visibleMountains(int[][] peaks) {

        for(int[] p : peaks){
             int x1 = p[0]-p[1];
             int x2 = p[0]+p[1];
             p[0]=x1;
             p[1]=x2;
        }

        Arrays.sort(peaks, (a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        int[] prev =peaks[0];
        int len = peaks.length;
        for(int i=1; i<len; i++){
            int[] curr = peaks[i];

            if(prev[1]<=curr[0]){
                prev= curr;
                cnt++;
                continue;
            }


            if(prev[0]==curr[0]&&  prev[1]<curr[1]){
                prev = curr;

            }else if(prev[0] < curr[0] && prev[1]<curr[1]){
                cnt++;
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }

        return cnt-1;



        
        // sweep line
        // TreeMap<Integer, Integer> map = new TreeMap<>(); // x, agg
        // for(int[] p : peaks){

        //      int x1 = p[0]-p[1];
        //      int x2 = p[0]+p[1];
        //      map.put(x1, map.getOrDefault(x1, 0)+1);
        //      map.put(x2+1, map.getOrDefault(x2+1, 0)-1);
             
        // }

        // int curr = map.firstKey();
        // int sum = 0 ;
        // int res =0 ;
        // for(int x : map.keySet()){
        //     int v = map.get(x);
        //     if(v>0)
        //         res++;
        // }
        



    }
}