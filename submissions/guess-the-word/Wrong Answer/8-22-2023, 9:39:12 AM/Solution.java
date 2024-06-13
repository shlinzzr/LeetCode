// https://leetcode.com/problems/guess-the-word

class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        Random random = new Random();
        List<String> wordList = new ArrayList();
        for(String w : words){
            wordList.add(w);
        }

        while(!wordList.isEmpty()){
            
            String guess = wordList.get(0);
            int match = master.guess(guess);
            if(match == 6){
                return;
            }
            
            List<String> temp = new ArrayList();
            for(String w : wordList){
                if(findMatches(w, guess) == match)
                    temp.add(w);
            }
            wordList = temp;
        }
    }

    public int findMatches(String w1, String w2){
        int count = 0;
        for(int idx = 0; idx < 6; idx++){
            if(w1.charAt(idx) == w2.charAt(idx)){
                count++;
            }
        }
        return count;
    }
}