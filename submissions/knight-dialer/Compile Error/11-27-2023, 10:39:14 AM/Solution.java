// https://leetcode.com/problems/knight-dialer

class Solution {
    public int knightDialer(int n) {
        List<List<Integer>> g = buildGraph();

        int M = (int) 1e9+7;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<=9; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){

                int p = 


            }
        }




    }

    private List<List<Integer>> buildGraph(List<List<Integer>> g){
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i<=9; i++){
            list.add(new ArrayList<>());
        }

        list.get(0).add(4);
        list.get(0).add(6);
        list.get(1).add(8);
        list.get(1).add(6);
        list.get(2).add(7);
        list.get(2).add(9);
        list.get(3).add(4);
        list.get(3).add(8);
        list.get(4).add(3);
        list.get(4).add(9);
        list.get(4).add(0);
        list.get(6).add(1);
        list.get(6).add(7);
        list.get(6).add(0);
        list.get(7).add(2);
        list.get(7).add(6);
        list.get(8).add(1);
        list.get(8).add(3);
        list.get(9).add(2);
        list.get(9).add(4);
        list.get(0).add(4);
        list.get(0).add(6);

        return list;
    }
}