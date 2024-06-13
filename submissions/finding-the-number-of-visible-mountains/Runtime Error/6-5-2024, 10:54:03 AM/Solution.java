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

        for(int[] p : peaks){
                System.out.println(p[0] + " " + p[1]);
        }

        int res= 0 ;
        int len = peaks.length;
        for(int i=0; i<len; i++){
            res++;
            int currEnd = peaks[i][1];
            if(peaks[i][0]==peaks[i+1][0]){
                res--;
            }

            while(i+1<len && currEnd>=peaks[i+1][1]){
                i++;
            }

        }

        return res;

        // int cnt=1;
        // int[] prev =peaks[0];
        

        // for(int i=1; i<len; i++){
        //     int[] curr = peaks[i];

        //     if(prev[1]<=curr[0]){
        //         prev= curr;
        //         cnt++;
        //         continue;
        //     }

        //     else if(curr[1]<=prev[1]) continue;

        //     prev = curr;
        //     cnt++;

        //       System.out.println(i + " " + curr[0] + " " + curr[1] + " "  + cnt);




        
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