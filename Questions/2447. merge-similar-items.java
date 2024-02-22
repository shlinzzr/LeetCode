// https://leetcode.com/problems/merge-similar-items

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res =new ArrayList<>();
        
        int[] arr = new int[1001];
        for(int[] item: items1){
            arr[item[0]]+=item[1];
        }
        for(int[] item: items2){
            arr[item[0]]+=item[1];
        }
        
        for(int i=0; i<1001;i++){
            
            
            if(arr[i]!=0){
                
                 res.add(new ArrayList<>(List.of(i, arr[i])));
            }
           
            
        }
        
        return res;
        
    }
}