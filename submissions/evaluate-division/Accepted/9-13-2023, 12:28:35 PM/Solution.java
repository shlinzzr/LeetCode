// https://leetcode.com/problems/evaluate-division

class Solution {

    // graph

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Map<String, Double>> g = new HashMap<>();
        buildGraph(equations, values, g);

        int len = queries.size();
        double[] res = new double[len];
        Arrays.fill(res, -1);

        HashSet<String> seen = new HashSet<>();

        for(int i=0; i<len; i++){
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            seen.add(a);
            dfs(g, a, b, seen, 1.0, i, res);
            seen.remove(a);
        }

        

        return res;

    }

    private void dfs( HashMap<String, Map<String, Double>> g, String a, String b,  HashSet<String> seen , double tmp,  int i, double[] res ){
        
        if(!g.containsKey(a) || !g.containsKey(b))
            return;
        
        if(g.get(a).containsKey(b)){
            res[i] = g.get(a).get(b)*tmp;
            return;
        }

        for(String next : g.get(a).keySet()){

            if(!seen.contains(next)){
                seen.add(next);
                dfs(g, next, b, seen, g.get(a).get(next)*tmp, i, res);
                seen.remove(next);
            }
        }
    }



    private void buildGraph(List<List<String>> equations, double[] values,  HashMap<String, Map<String, Double>> g ){

        for(int i=0; i<equations.size(); i++){
            
            List<String> eq = equations.get(i);

            String a = eq.get(0);
            String b = eq.get(1);

            g.putIfAbsent(a, new HashMap<>());
            g.putIfAbsent(b, new HashMap<>());
            g.get(a).put(a, 1.0);
            g.get(b).put(b, 1.0);

            g.get(a).put(b, values[i]);
            g.get(b).put(a, 1.0/values[i]);
        }
    }




}