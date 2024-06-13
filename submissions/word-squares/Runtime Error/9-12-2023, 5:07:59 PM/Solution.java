// https://leetcode.com/problems/word-squares

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>>  res = new ArrayList<>();
        int len = words.length;

        helper(words, res, new ArrayList<>());
        return res;
    }

    private void helper(String[] words, List<List<String>> res, List<String> curr){
        if(curr.size()==4){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<words.length; i++){
            String w = words[i];

            if(curr.isEmpty()){
                curr.add(w);
                helper(words, res, curr);
                curr.remove(curr.size()-1);

            }else{
                int siz = curr.size();
                
                boolean match = true;
                for(int j=0; j<siz; j++){
                    if(w.charAt(j)!=curr.get(j).charAt(siz)){
                        match=false;
                        break;
                    }
                }

                if(match){
                    curr.add(w);
                    helper(words, res, curr);
                    curr.remove(curr.size()-1);
                }
            }
        }



    }
}