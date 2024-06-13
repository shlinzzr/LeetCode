// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> lost1 = new HashSet<>();
        HashSet<Integer> lost2 = new HashSet<>();
        Set<Integer> all = new HashSet<>();

        for(int i=0; i<matches.length; i++){

            int win = matches[i][0];
            int lose = matches[i][1];

            all.add(win);
            all.add(lose);

            if(lost2.contains(lose)){
                continue;
            }else if(lost1.contains(lose)){
                lost1.remove(lose);
                lost2.add(lose);
            }else{
                lost1.add(lose);
            }
        }

        all.removeAll(lost1);
        all.removeAll(lost2);
        res.add(new ArrayList<>(all));
        res.add(new ArrayList<>(lost1));

        for(List<Integer> list : res){
            Collections.sort(list);
        }


        return res;


    }
}