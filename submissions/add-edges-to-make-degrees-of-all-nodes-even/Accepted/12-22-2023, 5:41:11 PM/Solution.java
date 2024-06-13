// https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Set<Integer>> adjacencyList  = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new HashSet<>());
        }
        for (List<Integer> e : edges) {
            adjacencyList.get(e.get(0)).add(e.get(1));
            adjacencyList.get(e.get(1)).add(e.get(0));
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> curSet = adjacencyList.get(i);
            if (curSet.size() % 2 == 1) {
                odd.add(i);
            }
        }
        if (odd.size() == 2) {
            for (int i = 1; i <= n; i++) {
                int e1 = odd.get(0);
                int e2 = odd.get(1);
                if (!adjacencyList.get(e1).contains(i) && !adjacencyList.get(e2).contains(i)) {
                    return true;
                }
            }
        }
        if (odd.size() == 4) {
            int e1 = odd.get(0);
            int e2 = odd.get(1);
            int e3 = odd.get(2);
            int e4 = odd.get(3);
            return (!adjacencyList.get(e1).contains(e2) && !adjacencyList.get(e3).contains(e4)) 
                || (!adjacencyList.get(e1).contains(e3) && !adjacencyList.get(e2).contains(e4)) 
                || (!adjacencyList.get(e1).contains(e4) && !adjacencyList.get(e2).contains(e3));
        }
        return odd.size() == 0;
    }
}