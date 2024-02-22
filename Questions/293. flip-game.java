// https://leetcode.com/problems/flip-game

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String>  res  = new ArrayList<>();
        char[] arr = currentState.toCharArray();
        
        int idx = currentState.indexOf("++");
        while(idx!=-1){
            
            arr[idx]='-';
            arr[idx+1]='-';
            res.add(new String(arr));
            arr = currentState.toCharArray();
            idx = currentState.indexOf("++", idx+1);
        }
        
        return res;
        
        
    }
    
}