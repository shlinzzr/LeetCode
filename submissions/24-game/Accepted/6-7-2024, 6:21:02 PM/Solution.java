// https://leetcode.com/problems/24-game

class Solution {
    public boolean judgePoint24(int[] cards) {

        //光如何動筆 就卡住... ?  如何做dfs

        //想法1. => 把所有card 加到list內 大亂鬥 直到剩一個

        List<Double> list = new ArrayList<>();
        for(int c: cards){
            list.add((double) c);
        }

        return dfs(list);
    }

    private boolean dfs(List<Double> list){
        if(list.size()==1){
            if(Math.abs(list.get(0)-24.0) <0.001) return true; // 算精度 abs 不要漏
            return false;
        }

        // find pair
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){

                List<Double> ans = cal(list.get(i), list.get(j));
                for(double a : ans){
                    List<Double> next = new ArrayList<>(list);
                    next.remove(j);
                    next.remove(i);
                    next.add(a);

                    // for(int k=0; k<list.size(); k++){
                    //     if(k!=i || k==j) continue;
                    //     next.add(list.get(k));
                    // }

                    if(dfs(next)) return true;
                }
            }
        }

        return false;



    }

    private List<Double> cal(double a, double b){
        List<Double> list = new ArrayList<>();
        list.add(a+b);
        list.add(a-b);
        list.add(b-a);
        list.add(a*b);
        list.add(a/b);
        list.add(b/a);
        return list;
    }
}