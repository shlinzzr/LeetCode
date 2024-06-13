// https://leetcode.com/problems/circular-sentence

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        
        for(int i=0; i<arr.length-1; i++){
            
            String word = arr[i];
            String next = arr[i+1];
            if(word.charAt(word.length()-1) != next.charAt(0)){
                
                // System.out.println(word + " " + next);
                return false;
            }
                
            
        }
        
        char st = sentence.charAt(0);
        char ed = sentence.charAt(sentence.length()-1);
        return st==ed;
    }
}
