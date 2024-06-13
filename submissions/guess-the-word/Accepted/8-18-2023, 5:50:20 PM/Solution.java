// https://leetcode.com/problems/guess-the-word

class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        Random random = new Random();
        List<String> wordList = new ArrayList();
        for(String w : words){
            wordList.add(w);
        }


        while(!wordList.isEmpty()){
            //Randlomly koi bi word ...ke liye guess function call kar
            String word = wordList.get(random.nextInt(wordList.size()));
            int match = master.guess(word);
            //fir je match 6 ae te return , else ...saare words layi chacraers compare karo jinne match ne oh potential candidates ne
            if(match == 6){
                return;
            }
            List<String> temp = new ArrayList();
            for(String w : wordList){
                if(findMatches(w, word) == match)
                    temp.add(w);
            }
            wordList = temp;// hun ...worDList nu update..karno means ke jinna da match ....nhi hoyea oh delete kardo
        }
    }

    public int findMatches(String w1, String w2){
        //This function counts the haracters that matches
        int count = 0;
        for(int idx = 0; idx < 6; idx++){
            if(w1.charAt(idx) == w2.charAt(idx)){
                count++;
            }
        }
        return count;
    }
}