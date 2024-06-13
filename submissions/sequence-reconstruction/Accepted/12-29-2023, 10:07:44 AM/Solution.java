// https://leetcode.com/problems/sequence-reconstruction

class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        int len = nums.length;
        HashMap<Integer, Set<Integer>> g = new HashMap<>();
        HashMap<Integer, Integer> deg = new HashMap<>();

        for(List<Integer> seq : sequences){

            if(seq.size()==1){
                deg.putIfAbsent(seq.get(0), 0);
                continue;
            }

            for(int i=0; i<seq.size()-1; i++){
                int a = seq.get(i);
                int b = seq.get(i+1);
                deg.putIfAbsent(a, 0);
                deg.putIfAbsent(b, 0);

                g.putIfAbsent(a, new HashSet<>());
                if(g.get(a).add(b))
                    deg.put(b, deg.get(b)+1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int k : deg.keySet()){
            if(deg.get(k)==0){
                q.offer(k);
            }
        }

        System.out.println(deg);

        int idx= 0;
        while(!q.isEmpty()) {

            if(q.size()!=1) return false;

            int p = q.poll();
            if(p!=nums[idx++]) return false;

            for(int next : g.getOrDefault(p, new HashSet<>())){
                 deg.put(next, deg.getOrDefault(next,0)-1);
                 if(deg.get(next)==0){
                     q.offer(next);
                 }
            }
        }
        System.out.println(idx);

        return idx==len;
    }
}