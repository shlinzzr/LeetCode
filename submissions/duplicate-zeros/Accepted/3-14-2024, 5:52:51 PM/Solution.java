// https://leetcode.com/problems/duplicate-zeros

class Solution {
    public void duplicateZeros(int[] arr) {
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length && list.size()<arr.length; i++){
            
            if(arr[i]==0){
                list.add(0);
                list.add(0);
            }else{
                list.add(arr[i]);
            }
        }
        
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        
        
        
    }
}