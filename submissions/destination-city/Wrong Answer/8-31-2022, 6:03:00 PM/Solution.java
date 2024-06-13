// https://leetcode.com/problems/destination-city

class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> p : paths){
            String k = p.get(0);
            String v = p.get(1);
            if(map.containsKey(v)){
                map.put(k, map.get(v));
                // map.remove(v);
            }else{
                map.put(k, v);    
            }
        }
        
        for(Map.Entry<String, String> en : map.entrySet()){
            String k = en.getKey();
            String v = en.getValue();
            System.out.println(k + " " + v);
            
            if(map.containsKey(v)){
                map.put(k, map.get(v));
            }
        }
        
        
        String resKey = (String)map.keySet().toArray()[0];
        
        System.out.println(resKey + " "+map.get(resKey) );
        return map.get(resKey);
        
        
    }
}