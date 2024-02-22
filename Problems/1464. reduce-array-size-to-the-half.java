// https://leetcode.com/problems/reduce-array-size-to-the-half

// class Solution {
//     public int minSetSize(int[] arr) {
//         Hash
        
//         for(int i : arr){
//              occ[i]++;
//         }
        
//         Arrays.sort(occ);
        
//         int cnt=0, total=0;
//         for(int i=occ.length-1; i>=0; i--){
            
//             total+=occ[i];
//             cnt++;
            
//             if(total>=arr.length/2)
//                 return cnt;
//         }
        
//         return -1;
//     }
// }
class Solution {
    public int minSetSize(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : a) 
            m.put(n, m.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((c, d) -> d - c);
        for (int n : m.keySet()) pq.offer(m.get(n));
        int res = 0, sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
            res++;
            if (sum >= (a.length + 1) / 2) return res;
        }
        return 0;
    }
}