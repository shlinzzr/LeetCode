// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs

class Solution {
    public int[] restoreArray(int[][] adj) {
        int len = adj.length;
        HashMap<Integer, List<Integer>> g = new HashMap<>();

        for(int[] a: adj){
            g.putIfAbsent(a[0],  new ArrayList<>());
            g.putIfAbsent(a[1],  new ArrayList<>());
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int k: g.keySet()){
            if(g.get(k).size()==1){
                q.offer(k);
                seen.add(k);
                list.add(k);
                break;
            }
        }

        while(!q.isEmpty()){

            int p = q.poll();
            for(int nxt : g.get(p)){
                if(!seen.contains(nxt)){
                    list.add(nxt);
                    q.offer(nxt);
                    seen.add(nxt);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;


    }
}