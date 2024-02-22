// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        int[] res = new int[rowIndex+1];
        for(int i=0; i<=rowIndex; i++){
            
            int[] temp = new int[rowIndex+1];

            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    temp[j]=1;
                }else{
                    temp[j]=res[j]+res[j-1];
                }
            }

            res = temp;

            if(i==rowIndex){
                List<Integer> list = new ArrayList<>();
                for(int r: res)
                    list.add(r);
                return list;
            }
                
            
        }
        
        
        return new ArrayList<>();
        
    }
}