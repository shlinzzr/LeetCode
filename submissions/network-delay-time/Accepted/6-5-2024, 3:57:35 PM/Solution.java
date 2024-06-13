// https://leetcode.com/problems/network-delay-time

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[k] = 0;

        // int[] indegree = new int[n];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] t: times){
            map.putIfAbsent(t[0], new HashMap<>());

            if(!map.get(t[0]).containsKey(t[1])){
                // indegree[t[1]]++;
                map.get(t[0]).put(t[1], t[2]);
            }
            if(map.get(t[0]).get(t[1])<t[2])
                map.get(t[0]).put(t[1], t[2]);
           
        }

        // // bf  要另外loop n =>  194ms
        // int loop = n;
        // while(loop-->0)
        // for(int src=1; src<=n; src++){

        //     if(arr[src]==Integer.MAX_VALUE) continue;
        //     for(int dst=1; dst<=n; dst++){
        //         if(src==dst) continue;

        //         if(map.getOrDefault(src, new HashMap<>()).containsKey(dst)){
        //             int w = map.get(src).get(dst);
        //             if(arr[src]+w < arr[dst]){
        //                 arr[dst] = arr[src]+w;
        //             }
        //         }
        //     }
        // }


        Queue<Integer> q = new LinkedList<>();
        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : map.getOrDefault(curr, new HashMap<>()).keySet()){
                int w = map.get(curr).get(next);
                if(arr[curr]+w < arr[next]){
                    arr[next] = arr[curr]+w;
                    q.offer(next);
                }
            }
        }


        int res = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++){

            if(arr[i]==Integer.MAX_VALUE) return -1;
            res = Math.max(res, arr[i]);
        }

        return res;
        
    }
}