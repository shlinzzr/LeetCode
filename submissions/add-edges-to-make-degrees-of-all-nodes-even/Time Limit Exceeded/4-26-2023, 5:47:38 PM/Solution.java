// https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(List<Integer> e : edges){
            map.putIfAbsent(e.get(0), new ArrayList<>());
            map.putIfAbsent(e.get(1), new ArrayList<>());
            
            map.get(e.get(0)).add(e.get(1));
            map.get(e.get(1)).add(e.get(0));
        }
        
        List<Integer> odd = new ArrayList();
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            if(en.getValue().size()%2==0)
                continue;
            
            odd.add(en.getKey());
        }
        
        if (odd.size() == 0) return true;
        if (odd.size() >  4) return false;

        if (odd.size() == 2) {
            for (int i = 1; i <= n; i++) {
                int firstElement = odd.get(0);
                int secondElement = odd.get(1);
                if (!map.get(firstElement).contains(i) && !map.get(secondElement).contains(i)) {
                    return true;
                }
            }
        }
        if (odd.size() == 4) {
            int firstElement = odd.get(0);
            int secondElement = odd.get(1);
            int thirdElement = odd.get(2);
            int fourthElement = odd.get(3);
            return (!map.get(firstElement).contains(secondElement) && !map.get(thirdElement).contains(fourthElement)) 
            || (!map.get(firstElement).contains(thirdElement) && !map.get(secondElement).contains(fourthElement)) 
            || (!map.get(firstElement).contains(fourthElement) && !map.get(secondElement).contains(thirdElement));
        }
        return odd.size() == 0;
    }
}
