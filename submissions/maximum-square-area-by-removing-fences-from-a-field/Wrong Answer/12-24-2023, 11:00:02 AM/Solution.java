// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field

class Solution {
    public int maximizeSquareArea(int h, int w, int[] hFences, int[] vFences) {
        int M = (int) 1e9+7;
        
        HashSet<Integer> hset = new HashSet<>();
        HashSet<Integer> wset = new HashSet<>();
        
        getAll(hFences, hset, h);
        getAll(vFences, wset, w);
        
        List<Integer> hList = new ArrayList<>(hset);
        // List<Integer> wList = new ArrayList<>(wset);
        
        Collections.sort(hList);
        // Collections.sort(wList);
        
        for(int i=hList.size()-1; i>0; i--){
            if( wset.contains(hList.get(i)))
                return (int)(1L * hList.get(i) *hList.get(i)  %M) ;
        }
        
        return -1;
        
    }
    
    
    private void getAll(int[] fences, HashSet<Integer> set, int max){
        for(int f : fences){
            set.add(f-1);
        }
        set.add(max-1);
        
       
        
        for(int a : new ArrayList<>(set)){
            for(int b : new ArrayList<>(set)){
                set.add(Math.abs(a-b));
            }
        }
        
         // System.out.println(set);
    }
}