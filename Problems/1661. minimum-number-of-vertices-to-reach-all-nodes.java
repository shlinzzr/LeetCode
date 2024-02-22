// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] arr = new int[n];
        
        for(List<Integer> list : edges){
            arr[list.get(1)]++;
        }
        
        
        for(int i=0; i<n; i++){
            if(arr[i]==0)
                res.add(i);
        }
        
        return res;
        
        
    }
}