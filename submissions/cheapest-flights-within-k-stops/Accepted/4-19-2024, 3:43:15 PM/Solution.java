// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
        int[] p = new int[n]; // let price arr be the price from src to each stop
        Arrays.fill(p, Integer.MAX_VALUE);
        p[src] = 0;

        for(int i=0; i<k+1; i++){

            int[] tmp = Arrays.copyOf(p, n);
            for(int[] f : flights){
                int st = f[0];
                int ed = f[1];
                int cost = f[2];

                if(p[st]!=Integer.MAX_VALUE){
                    tmp[ed] = Math.min(tmp[ed], p[st]+cost);
                }
            }

            p=tmp; 
        }

        return p[dst]==Integer.MAX_VALUE? -1 : p[dst];
        
    }
}