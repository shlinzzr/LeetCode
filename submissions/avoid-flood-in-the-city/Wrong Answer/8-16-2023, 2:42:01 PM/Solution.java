// https://leetcode.com/problems/avoid-flood-in-the-city

class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> flood = new HashSet<>();
        
        for(int i=0; i<len; i++){
            
            int r = rains[i];
            
            if(r==0){
                
                int t=i+1;
                
                boolean flag=false;
                while(t<len){
                    if(rains[t]!=0 && set.contains(rains[t])){
                        flag=true;
                        set.remove(rains[t]);
                        res[i] = rains[t];
                        break;
                    }
                    t++;
                }
                
                if(flag==false){
                    t=i+1;
                    while(t<len){
                        if(rains[t]!=0){
                            flag=true;
                            set.remove(rains[t]);
                            res[i] = rains[t];
                            break;
                        }
                        t++;
                    }
                }
                
                
            }else{
                
                if(set.contains(r)){
                    flood.add(r);
                }
                res[i]=-1;
                set.add(r);
            }
            // System.out.println(i+ " " + r+ " " + set);
            
        }
        
        
        return !flood.isEmpty()? new int[0] : res;
        
        
        
    }
}