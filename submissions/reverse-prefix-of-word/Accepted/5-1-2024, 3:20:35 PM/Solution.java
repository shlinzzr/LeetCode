// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {

        StringBuilder sb = new StringBuilder();
        boolean done =false;
        for(char chh : word.toCharArray()){
            sb.append(chh);
            if(chh==ch && done==false){
sb = sb.reverse();
done = true;
            }
        }
        
        return sb.toString();
    }
}