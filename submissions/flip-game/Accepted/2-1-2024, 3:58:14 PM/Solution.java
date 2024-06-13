// https://leetcode.com/problems/flip-game

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        

        List<String> res = new ArrayList<>();
        // Set<String> seen = new HashSet<>();
        // helper(currentState, seen, res);

        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i]=='+' && arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';
                res.add(new String(arr));
                arr[i]='+';
                arr[i+1]='+';
            }
        }


        return res;


    }



}