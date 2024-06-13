// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        int[] count = new int[k];
        int len = arrival.length;
        
        PriorityQueue<int[]> busyServer = new PriorityQueue<>(
            (a,b)-> a[0]-b[0]
        );
            
            
        TreeSet<Integer> avail = new TreeSet<>();
        for(int i=0; i<k; i++){
            avail.add(i);
        }
        
        for(int i=0; i<len; i++){
        
            int st = arrival[i];
            int ed = arrival[i] + load[i];
            
            while(!busyServer.isEmpty() && busyServer.peek()[0]<=st){
                avail.add(busyServer.poll()[1]);
            }
            
            
            if(avail.isEmpty())// all server busy
                continue;
            
            Integer serverId = avail.ceiling(i%k);
            if(serverId==null){
                serverId = avail.first();
            }
            
            avail.remove(serverId);
            busyServer.offer(new int[]{ed, serverId});
            count[serverId]++;
        }
        
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
        
        
        
        // double for loop cause TLE 1e10
//         int[] count = new int[k];
//         boolean[] isBusy = new boolean[k];
        
//         HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>(); // serverid, <st, ed>
//         // ok
//         // ----|>---<|---insert---|>----<|--
//         //     st   ed            st.   ed
//         //.   (if ed null, st must null),   (if st null, ed must null) && (if ed exist, st must< insert)&& (if st not null, ed must > st)
        
//         // fail
//         // ---<|--|>--insert---<|--|>--
//         //    ed  st           ed  st
//         //   (ed null or ed<st)    (st null or st>ed)
        
//         int len = arrival.length;
        
//         for(int i=0; i<len; i++){ //1e5
//             int st = arrival[i];
//             int ed = st+load[i];
            
//             boolean found = false;
//             int id =0;
//             for(int j=0; j<k; j++ ){   // 1e5
                
//                 id = (i+j)%k;
//                 map.putIfAbsent(id, new TreeMap<>());
                
//                 Integer prevSt = map.get(id).lowerKey(st);
//                 if(prevSt==null){
//                     map.get(id).put(st, ed);
//                     found=true;
//                     break;
//                 }else{
//                     int prevEd = map.get(id).get(prevSt);
//                     if(prevEd<=st){
//                         map.get(id).put(st, ed);
//                         found = true;
//                         break;
//                     }else{
//                         // server is busy
//                     }
//                 }
//             }
            
//             if(found==false) // all server busy
//             {
//                 continue;
//             }
            
//             count[id]++;
//         }
        
//         // for(int c: count){
//         //     System.out.print(c + ",");    
//         // }
//         // System.out.println();
        
        
//         int max= 0;
//         List<Integer> res = new ArrayList<>();
//         for(int i=0; i<k; i++){
//             if(count[i]>max){
//                 max = count[i];
//                 res = new ArrayList<>();
//                 res.add(i);
//             }else if(count[i]==max){
//                 res.add(i);
//             }
//         }

//         return res;
            
            
    }
}