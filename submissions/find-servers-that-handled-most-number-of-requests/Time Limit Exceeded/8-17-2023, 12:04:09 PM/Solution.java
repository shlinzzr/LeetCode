// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        boolean[] isBusy = new boolean[k];
        
        HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>(); // serverid, <st, ed>
        // ok
        // ----|>---<|---insert---|>----<|--
        //     st   ed            st.   ed
        //.   (if ed null, st must null),   (if st null, ed must null) && (if ed exist, st must< insert)&& (if st not null, ed must > st)
        
        // fail
        // ---<|--|>--insert---<|--|>--
        //    ed  st           ed  st
        //   (ed null or ed<st)    (st null or st>ed)
        
        int len = arrival.length;
        
        for(int i=0; i<len; i++){
            int st = arrival[i];
            int ed = st+load[i];
            
            boolean found = false;
            int id =0;
            for(int j=0; j<k; j++ ){
                
                id = (i+j)%k;
                map.putIfAbsent(id, new TreeMap<>());
                
                Integer prevSt = map.get(id).lowerKey(st);
                if(prevSt==null){
                    map.get(id).put(st, ed);
                    found=true;
                    break;
                }else{
                    int prevEd = map.get(id).get(prevSt);
                    if(prevEd<=st){
                        map.get(id).put(st, ed);
                        found = true;
                        break;
                    }else{
                        // server is busy
                    }
                }
            }
            
            if(found==false) // all server busy
            {
                continue;
            }
            
            count[id]++;
        }
        
        // for(int c: count){
        //     System.out.print(c + ",");    
        // }
        // System.out.println();
        
        
        int max= 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(count[i]>max){
                max = count[i];
                res = new ArrayList<>();
                res.add(i);
            }else if(count[i]==max){
                res.add(i);
            }
        }

        return res;
            
            
    }
}