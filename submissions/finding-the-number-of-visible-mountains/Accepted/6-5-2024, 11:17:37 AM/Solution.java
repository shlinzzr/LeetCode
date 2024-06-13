// https://leetcode.com/problems/finding-the-number-of-visible-mountains

class Solution {
    public int visibleMountains(int[][] peaks) {

        if(peaks.length==1) return 1;

        for(int[] p : peaks){
             int x1 = p[0]-p[1];
             int x2 = p[0]+p[1];
             p[0]=x1;
             p[1]=x2;
        }

        Arrays.sort(peaks, (a,b)->a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1]);

        int len = peaks.length;
        

        int[] prev =peaks[0];
        int[] curr =peaks[1];

        int cnt = prev[0]==curr[0] && prev[1]==curr[1] ? 0 : 1;
        int maxRight = prev[1];
        
        for(int i=1; i<len; i++){
            curr = peaks[i];
            if(curr[1] <= maxRight) continue;
            maxRight = curr[1];
            if(i==len-1 || curr[0]!=peaks[i+1][0] || maxRight!=peaks[i+1][1]) cnt++;
           
        }
        return cnt;




        
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