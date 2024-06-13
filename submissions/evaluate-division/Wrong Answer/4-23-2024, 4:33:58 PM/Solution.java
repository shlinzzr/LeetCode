// https://leetcode.com/problems/evaluate-division

class Solution {
    
    
    public double[] calcEquation(List<List<String>> equations, double[] vals, List<List<String>> queries) {
        
        int size = queries.size();
        double[] res = new double[size];
        
        Map<String ,Map<String, Double>> map = new HashMap<>();
        
        for(int i=0; i<equations.size(); i++){
            List<String> e = equations.get(i);
            String a = e.get(0);
            String b = e.get(1);
            double v = vals[i];
            
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, v);
            map.get(a).put(a, 1.0);
            
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1.0/v);
            map.get(b).put(b, 1.0);
            
        }
        
        
        Set<String> keys = map.keySet();
        for(String ka : keys){
            for(String kb : keys){
                if(ka.equals(kb)) continue;
                
                for(String kc : keys){
                    if(kc.equals(kb) || kc.equals(ka)) continue;
                    if(map.get(ka).containsKey(kc)) continue;
                    
                    if(map.get(ka).containsKey(kb) && map.get(kb).containsKey(kc)){
                        
                        double va = map.get(ka).get(kb);
                        double vb = map.get(kb).get(kc);
                        map.get(ka).put(kc, va*vb);
                        map.get(kc).put(ka, vb*va);                        
                    }
                }
            }
        }
        
        for(int i=0; i<size; i++){
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            res[i] = !map.containsKey(a) || !map.get(a).containsKey(b) ? -1 : map.get(a).get(b);
        }
        
        return res;
        
        
    }
}