// https://leetcode.com/problems/minimize-max-distance-to-gas-station

class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int len = stations.length;

        PriorityQueue<Double> pq = new PriorityQueue<>(
            new Comparator<Double>(){
                public int compare(Double a , Double b){
                    if(a==b) return 0;
                    return a<b ? 1 : -1;
                }
            }
        );

        for(int i=0; i<len-1; i++){
            pq.offer(Double.valueOf(stations[i+1]-stations[i]));
        }

        while(k>0){
            double d = pq.poll();
            pq.offer(d/2);
            pq.offer(d/2);
            k--;
        }

        return pq.peek();


    }
}