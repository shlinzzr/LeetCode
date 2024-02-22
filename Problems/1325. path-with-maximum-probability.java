// https://leetcode.com/problems/path-with-maximum-probability

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> g = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int[] e = edges[i];
            g.putIfAbsent(e[0], new ArrayList<>());
            g.putIfAbsent(e[1], new ArrayList<>());
            g.get(e[0]).add(new Pair<>(e[1], succProb[i]));
            g.get(e[1]).add(new Pair<>(e[0], succProb[i]));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((a,b)-> -Double.compare(a.getValue(),b.getValue()));
        pq.add(new Pair<>(start,1.0));

        while (!pq.isEmpty()){
            Pair<Integer,Double> curr = pq.poll();

            if(curr.getKey()==end)
                return curr.getValue();

            for(Pair<Integer,Double> next: g.getOrDefault(curr.getKey(),new ArrayList<>())){
                if(curr.getValue()* next.getValue() > maxProb[next.getKey()]){
                    maxProb[next.getKey()] = (double)curr.getValue()* next.getValue();
                    pq.add(new Pair<>(next.getKey(), maxProb[next.getKey()]));
                }
            }
        }
        return 0.0;
    }
}