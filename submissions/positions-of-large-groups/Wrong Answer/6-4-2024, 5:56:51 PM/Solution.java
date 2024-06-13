// https://leetcode.com/problems/positions-of-large-groups

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> res= new ArrayList<>();
        
        int len = s.length();
        char[] arr = s.toCharArray();
        for(int i=0; i<len; i++){
            for(int j=i; j<len-1; j++){
                
                if(arr[j]!=arr[j+1]){
                    
                    if(j-i+1>=3){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                    i=j;
                    break;
                }
            }
        }
        
        return res;
            
        
    }
}