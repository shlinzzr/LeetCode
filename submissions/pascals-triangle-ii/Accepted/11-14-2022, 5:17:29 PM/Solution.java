// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<=rowIndex; i++){
            
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    rowList.add(1);
                }else{
                    rowList.add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
                }
                
                
            }
            if(i==rowIndex)
                return rowList;
            
            list.add(new ArrayList<>(rowList));
        }
        
        
        return new ArrayList<>();
        
    }
}