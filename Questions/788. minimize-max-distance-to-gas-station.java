// https://leetcode.com/problems/minimize-max-distance-to-gas-station

class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        
        /*

        s[i+1]- s[i] == distance
        ==> if(distance > penalty). cnt++;   xx wrong

        need calculate how many gas stations between i & i+1
        => math.ceil((s[i+1] - s[i]) / mid) - 1


        check cnt > k



        */

        double offset = (double) 1e-6;

        int len = stations.length;

        Arrays.sort(stations);
 
        double st =0, ed=0;

        for(int i=0; i<len-1; i++){
            ed = Math.max(ed, stations[i+1]-stations[i]);
        }

        while(st+offset<ed){
            
            double mid = (st+ed)/2;
            int count = 0;

            for(int i=0; i<len-1;i++){
                count += Math.ceil((stations[i+1]-stations[i])/ mid) -1;
            }

            if(count>k){
                st = mid;
            }else{
                ed = mid;
            }
        }


        return st;


    }


    private boolean isOk(int[] s, double mid, int k){
        int len = s.length;

        for(int i=0; i<len-1; i++){
            if((s[i+1]-s[i])/2.0 < mid){

                // System.out.println("hello k=" + k);
                // System.out.println(i + " s[i+1]-s[i])/2.0=" + (s[i+1]-s[i])/2.0);

                if(k<0)
                    return false;
                k--;
            }
        }

        return true;


    }
}