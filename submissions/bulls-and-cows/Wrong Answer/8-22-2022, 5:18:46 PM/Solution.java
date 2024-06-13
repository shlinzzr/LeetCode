// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
     
        int len = secret.length();
        // HashSet<Character> set = new HashSet<>();
        
        int cntA = 0, cntB=0;
        for(int i=0; i<len; i++){
            // setA.add(secret.charAt(i));
            
            if(secret.charAt(i) == guess.charAt(i)){
                cntA++;
                
            }else if(secret.contains(guess.charAt(i)+"")){
                cntB++;
            }            
        }
        
        return cntA+ "A" + cntB + "B";
        
        
    }
}