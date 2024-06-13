// https://leetcode.com/problems/goal-parser-interpretation

class Solution {
//     public String interpret(String command) {
//         command = command.replaceAll("\\(\\)", "o");
//         command = command.replaceAll("\\(al\\)","al");
        
//         return command;
//     }
    
    public String interpret(String command) {
        StringBuilder sb =new StringBuilder();
        
        int i=0;
        while(i<command.length()){
            
            if(command.charAt(i)=='(' && command.charAt(i+1)==')'  ){
                sb.append("o");
                i+=2;
            }else if(command.charAt(i)=='(' && command.charAt(i+1)=='a'  ){
                
                sb.append("al");
                i+=4;
                
            }else{
                sb.append(command.charAt(i));
                i++;
                
                
            }
            
            
            
        }
        
        
        return sb.toString();
    }
}