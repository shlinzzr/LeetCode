// https://leetcode.com/problems/word-squares

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        int len = words.length;
        backtrack(words, res, new ArrayList<>());
        return res;
    }

    private void backtrack(String[] words, List<List<String>> res, List<String> curr){

        int wordLen = words[0].length();

        if(curr.size()==wordLen){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<words.length;i++){
            String w = words[i];

            if(isValid(curr, w)){
                curr.add(w);
                backtrack(words, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isValid(List<String> curr, String s ){

        if(curr.isEmpty())
            return true;

        int siz = curr.size();
        for(int j=0; j<siz; j++){
            if(s.charAt(j)!=curr.get(j).charAt(siz)){
                return false;
            }
        }

        return true;
    }   
}

/* 

b a l l 
a r e a
l e a d
l a d y

*/