// https://leetcode.com/problems/count-nodes-with-the-highest-score

class Solution {
     Map<Integer, List<Integer>> g ;
     Map<Integer, Integer> cntMap;
     Map<Integer, List<Integer>> childCnt;
    public int countHighestScoreNodes(int[] parents) {
        g = new HashMap<>();
        cntMap = new HashMap<>();
        childCnt = new HashMap<>();

        int len = parents.length;
        for(int i=1; i<len ;i++){
            g.putIfAbsent(i , new ArrayList());
            g.get(i).add(parents[i]);
        }

        int sum = getCnt(0);

        int res = 0;
        for(int i=0; i<len ;i++){
            int ans = sum-cntMap.getOrDefault(i,1);

            int tmp = 1;
            for(int child : childCnt.get(i)){
                tmp*=child;
            }

            if(ans!=0)
                tmp*=ans;
            res += tmp;

        }

        return res;

        
    }

    private int getCnt(int cur){ // 包含自己的個數
        if(!g.containsKey(cur)){
            return 1;
        }


        childCnt.putIfAbsent(cur, new ArrayList<>());
        int sum =1 ;
        for(int child : g.get(cur)){
            int cnt = getCnt(child);
            childCnt.get(cur).add(cnt);
            sum += cnt;
        }

        cntMap.put(cur, sum);
        return sum;

    }
}