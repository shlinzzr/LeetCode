// https://leetcode.com/problems/get-watched-videos-by-your-friends

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> wv, int[][] F, int id, int level) {

        HashMap<String, Integer> fmap = new HashMap<>();

        HashSet<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();


        q.offer(id);
        seen.add(id);

         while(!q.isEmpty() && level-->=0){
            fmap = new HashMap<>();
            int siz = q.size();
            for(int i=0; i<siz; i++){

                int p = q.poll();
                for(String vid : wv.get(p)){
                    fmap.put(vid, fmap.getOrDefault(vid, 0)+1);
                }

                for(int next : F[p]){
                    if(!seen.contains(next))
                        q.offer(next);
                }

            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue()-b.getValue()
        );

        pq.addAll(fmap.entrySet());
        List<String> res =new ArrayList<>();


        while(!pq.isEmpty())
            res.add(pq.poll().getKey());


        return res;


        
    }
}