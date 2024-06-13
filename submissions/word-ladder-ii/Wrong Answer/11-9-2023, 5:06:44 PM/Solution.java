// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>>  res =new ArrayList<>();
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
        Queue<List<String>> q = new LinkedList<>();
        
        q.offer(ini);
        int step=1;

        

        while(!q.isEmpty()){

            int siz=q.size();
            while(siz-->0){

                List<String> list = q.poll();
                String p = list.get(list.size()-1);

                for(int i=0; i<p.length(); i++){

                    char[] arr = p.toCharArray();

                    for(int j=0; j<26; j++){
                        arr[i] = (char) (j+'a');

                        String t = new String(arr);

                        if(t.equals(endWord)){
                            list.add(t);
                            


                            if(!res.isEmpty()){
                                if(list.size()>res.get(0).size())
                                    continue;
                                if(list.size()<res.get(0).size()){
                                    res = new ArrayList<>();
                                }
                            }
                            res.add(new ArrayList<>(list));
                            continue;
                        }

                        if(set.contains(t) && !seen.contains(t)){
                            seen.add(t);
                            List<String> tmp = new ArrayList<>(list);
                            tmp.add(t);
                            q.offer(tmp);
                        }
                    }
                }
            }
            step++;
        }

        return res;
    }
}