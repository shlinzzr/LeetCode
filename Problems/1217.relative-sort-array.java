// https://leetcode.com/problems/relative-sort-array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int a2: arr2){
            set.add(a2);
        }
        
        List<Integer> list2 = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a1 : arr1){
            if(set.contains(a1))
                map.put(a1, map.getOrDefault(a1,0)+1);
            else list2.add(a1);
        }
        
        Collections.sort(list2);
        
        List<Integer> list = new ArrayList<>();
        for(int a2 : arr2){
            
            int loop = map.get(a2);
            while(loop-->0)
                list.add(a2);
        }
        
        list.addAll(list2);
        
        
        
       
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}