// https://leetcode.com/problems/avoid-flood-in-the-city

class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> flood = new HashSet<>();
        
        for(int i=0; i<len; i++){
            
            int r = rains[i];
            
            if(r==0){
                
                
                int t=i+1;
                
                boolean flag=false;
                while(t<len){
                    if(rains[t]!=0 && map.containsKey(rains[t])){
                        flag=true;
                        res[i] = map.get(rains[t]);
                        map.remove(rains[t]);
                        break;
                    }
                    t++;
                }
                
                if(flag==false){
                    
                    for(int key: map.keySet()){
                          flag=true;
                            res[i] = map.get(key);
                            map.remove(key);
                    }
                }
                
                
            }else{
                
                if(map.containsKey(r)){
                    flood.add(r);
                }
                res[i]=-1;
                map.put(r,r);
            }
            // System.out.println(i+ " "  + map.keySet());
            
        }
        
        
        return !flood.isEmpty()? new int[0] : res;
        
        
        
    }
}