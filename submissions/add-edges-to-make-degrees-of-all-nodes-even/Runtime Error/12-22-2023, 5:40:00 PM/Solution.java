// https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashMap<Integer, List<Integer>> g =new HashMap<>();

        HashSet<Integer> oddSet = new HashSet<>();

        HashSet<String> exists = new HashSet<>();

    
        for(List<Integer> e: edges){

            int a = e.get(0);
            int b = e.get(1);

            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(b);
            g.get(b).add(a);

            if(a>b){
                int t = a;
                a = b;
                b = t;
            }

            exists.add(a+"_"+b);

            // if(g.get(a).size()%2==0) oddSet.remove(a);
            // else oddSet.add(a);

            // if(g.get(b).size()%2==0) oddSet.remove(b);
            // else oddSet.add(b);
        }


        for (int i = 1; i <= n; i++) {
            List<Integer> list = g.get(i);
            if (list.size() % 2 == 1) {
                oddSet.add(i);
            }
        }

        if(oddSet.size()%2!=0) return false;
        if(oddSet.size()>4) return false;

        List<Integer> list = new ArrayList<>(oddSet);
        // Collections.sort(list);

        if (list.size() == 2) {
            for (int i = 1; i <= n; i++) { // 1-n 找一個節點 搞兩個連結
                int e1 = list.get(0);
                int e2 = list.get(1);
                if (!g.get(e1).contains(i) && !g.get(e2).contains(i)) {
                    return true;
                }
            }
        }
        if (list.size() == 4) {
            int e1 = list.get(0);
            int e2 = list.get(1);
            int e3 = list.get(2);
            int e4 = list.get(3);
            if ((!g.get(e1).contains(e2) && !g.get(e3).contains(e4)) 
                || (!g.get(e1).contains(e3) && !g.get(e2).contains(e4)) 
                || (!g.get(e1).contains(e4) && !g.get(e2).contains(e3)))
                return true;
        }
        return list.size()==0;



    }
}