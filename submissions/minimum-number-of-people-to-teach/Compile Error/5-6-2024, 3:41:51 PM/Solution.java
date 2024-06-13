// https://leetcode.com/problems/minimum-number-of-people-to-teach

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // n languages, m users

        int m = languages.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>();

        Map<String, Integer > map = new HashMap<>();
        boolean[] skip = new boolean[friendships.length];
        for(int i=0; i<friendships.length; i++){
            int[] fs = friendships[i];
            int u = fs[0];
            int v = fs[1];

            int[] lan_u = languages[u];
            int[] lan_v = languages[v];
            Set<Integer> set_u = new HashSet<>();
            for(int l : lan_u){
                set_u.add(l);
            }

            Set<Integer> set_v = new HashSet<>();
            for(int l : lan_v){
                set_v.add(l);
            }

            Set<Integer> intersec = set_v.retain(set_u);
            if(intersec.size()>0) {
                skip[i] = true;
                continue;
            }

            for(int l : set_u){
                String str = u+"_"+l;
                map.put(str, map.getOrDefault(str, 0)+1);
            }

            for(int l : set_v){
                String str = v+"_"+l;
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }



        



    }
}