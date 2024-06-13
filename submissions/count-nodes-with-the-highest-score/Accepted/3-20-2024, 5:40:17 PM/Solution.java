// https://leetcode.com/problems/count-nodes-with-the-highest-score

class Solution {
     Map<Integer, List<Integer>> g ;
     Map<Integer, Integer> cntMap;

    public int countHighestScoreNodes(int[] parents) {
        g = new HashMap<>();
        cntMap = new HashMap<>();

        int len = parents.length;
        for(int i=1; i<len ;i++){
            g.putIfAbsent(parents[i] , new ArrayList());
            g.get(parents[i]).add(i);
        }

        int total = getCnt(0);
        // System.out.println(total);

        long highest = 0;
        int nodeCnt = 0;
        int res = 0;
        for(int i=0; i<len ;i++){
          
            long ans = total - cntMap.get(i);

           

            long tmp = 1;
            for(int child : g.getOrDefault(i, new ArrayList<>())){
                tmp *= cntMap.get(child);
            }

            if(ans!=0) 
                tmp*=ans;
            //  System.out.println( "i="+i + " ans="+ans + " tmp="+tmp);

            if(tmp>highest){
                nodeCnt = 1;
                highest = tmp;
            }else if(tmp==highest){
                nodeCnt++;
            }
        }

        return nodeCnt;

        
    }

    private int getCnt(int cur){ // 包含自己的個數
        if(!g.containsKey(cur)){
            cntMap.put(cur, 1);
            return 1;
        }

        int sum =1 ;
        for(int child : g.get(cur)){
            int cnt = getCnt(child);
            sum += cnt;
        }

        cntMap.put(cur, sum);
        return sum;

    }
}