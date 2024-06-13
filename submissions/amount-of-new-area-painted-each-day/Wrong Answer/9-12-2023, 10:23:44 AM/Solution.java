// https://leetcode.com/problems/amount-of-new-area-painted-each-day

class Solution {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int len = paint.length;

        int[] worklog = new int[len];

        for(int i=0; i<len; i++){

            int cnt=0;

            int st = paint[i][0];
            int ed = paint[i][1];

            Integer floor  = map.floorKey(st);
            if(floor!=null && map.get(floor)>st)
                st = Math.max(st, map.get(floor));

            System.out.println(st + " " + floor);

            Integer ceiling = map.ceilingKey(st);

            if(ceiling==null && ed-st>0){
                map.put(st,ed);
                cnt += ed-st;
                worklog[i]=cnt;
                continue;
            }



            while(ceiling!=null && ceiling<ed){
                map.put(st,ceiling);
                cnt += ceiling-st;
                st=map.get(ceiling);
                ceiling=map.ceilingKey(map.get(ceiling));
            }

            worklog[i] = cnt;
        }

        return worklog;
    }
}