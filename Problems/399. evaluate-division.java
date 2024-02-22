// https://leetcode.com/problems/evaluate-division

class Solution {

    // graph https://www.youtube.com/watch?v=u9LE_7apB38

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Map<String, Double>> g = new HashMap<>();
        buildGraph(equations, values, g);

        double[] res = new double[queries.size()];
        Arrays.fill(res, -1);

        for(int i=0; i<queries.size(); i++){
            List<String> q = queries.get(i);
            String src = q.get(0);
            String dst = q.get(1);

            HashSet<String> seen = new HashSet<>();
            seen.add(src);
            dfs(g, src, dst, seen, 1.0, i, res);
        }

        

        return res;

    }


    private void dfs( HashMap<String, Map<String, Double>> g, String src, String dst, HashSet<String> seen, double cur, int i, double[] res){
        if(!g.containsKey(src)  || !g.containsKey(dst))
            return;

        if(g.get(src).containsKey(dst)){
            res[i] = g.get(src).get(dst)*cur;
            return;
        }

        for(String next : g.get(src).keySet()){
            if(!seen.contains(next)){
                seen.add(next);
                dfs(g, next, dst, seen, g.get(src).get(next)*cur, i, res);
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