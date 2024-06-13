// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set= new HashSet<>();
        for(int i=0; i<arr.length; i++){
            
            for(int j=0; j<arr.length; j++){
                if(i==j)
                    continue;
                
                int a = arr[i];
                int b = arr[j];
                if(Math.abs(a-x) <Math.abs(b-x) || (Math.abs(a-x)==Math.abs(b-x) && a<b))
                    set.add(a);
                
                
            }
        }
        
        return new ArrayList<>(set);
    }
}