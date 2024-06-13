// https://leetcode.com/problems/word-ladder-ii

class Solution {

List<List<String>>  res =new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // List<List<String>>  res =new ArrayList<>();
        Set<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord))
            return res;

        if(beginWord.length()!=endWord.length() )
            return res;

        List<String> ini = new ArrayList<>();
        ini.add(beginWord);
        

        if(beginWord.equals(endWord)){
            res.add(ini);
            return res;
        }
            

        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        
        helper( ini, set, seen, endWord);


        return res;
    }


    private void helper( List<String> curr, Set<String> set, Set<String> seen, String target){
        
        if(curr.get(curr.size()-1).equals(target)){

            if(!res.isEmpty()){
                if(curr.size()>res.get(0).size())
                    return;

                if(curr.size()<res.get(0).size()){
                    res = new ArrayList<>();
                }
                res.add(new ArrayList<>(curr));
            }else{
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if(!res.isEmpty() && curr.size()>=res.get(0).size()){
            return;
        }

        String p = curr.get(curr.size()-1);
        for(int i=0; i<p.length(); i++){
            char[] arr = p.toCharArray();
            for(int j=0; j<26; j++){
                arr[i] = (char)(j+'a');
                String t = new String(arr);
                if(set.contains(t) && !seen.contains(t)){
                    curr.add(t);
                    seen.add(t);
                    helper( curr, set, seen, target);
                    curr.remove(curr.size()-1);
                    seen.remove(t);
                }
            }
        }


    }
}