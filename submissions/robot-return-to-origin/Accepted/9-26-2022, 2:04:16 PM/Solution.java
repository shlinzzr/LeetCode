// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        int[] axis = new int[2];
        
        for(char c : moves.toCharArray()){
            
            if(c=='U'){
                axis[1]++;
                
            }else if(c=='D'){
                axis[1]--;
            }else if(c=='L'){
                axis[0]--;
            }else if(c=='R'){
                axis[0]++;
            }
        }
        
        return axis[0]==0 && axis[1]==0;
        
    }
}