// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int len = flights.length;
        HashMap<Integer, HashMap<Integer, Integer>> g = new HashMap<>();
        for(int[] f: flights){
            int from = f[0];
            int to = f[1];
            int price = f[2];
            g.putIfAbsent(from, new HashMap<>());
            g.get(from).put(to, price);
        }

        
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        k++;
        while(!q.isEmpty() && k-->0){//2 , 1

            int[] tmp = Arrays.copyOfRange(arr, 0, n);
            int siz = q.size(); // 1 ,2 
            for(int i=0; i<siz; i++){ 
                int p = q.poll();  

                HashMap<Integer, Integer> adj = g.getOrDefault(p, new HashMap<>());  // 1 2
                for(int next : adj.keySet()){
                    tmp[next] = Math.min(arr[next], arr[p]+adj.get(next)); // arr[1]=1 , arr[2]=5

                    q.offer(next);
                }
            }

            arr = tmp;
        }

        return arr[dst]==Integer.MAX_VALUE ? -1 : arr[dst];

    }
}