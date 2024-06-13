// https://leetcode.com/problems/queue-reconstruction-by-height

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);

        int len = people.length;
        List<int[]> res = new ArrayList<>();
        boolean[] seen = new boolean[len];
        helper(people, res, seen);

        // System.out.println(res.size());

        int[][] ret = new  int[len][2];
        for(int i=0; i<len; i++){
            ret[i] = res.get(i);
        }

        return ret;

    }


    private void helper(int[][] people, List<int[]> res, boolean[]seen){

        if(res.size()==people.length){
            return;
        }

        for(int i=0; i<people.length; i++){

            int[] p = people[i];

            if(seen[i]==false){
                int cnt =0;
                for(int[] r : res){
                    if(p[0]<=r[0])
                        cnt++;
                    if(cnt>p[1])
                        break;
                }
                if(cnt!=p[1])
                    continue;

                seen[i]=true;
                res.add(p);
                // System.out.println("add "+ i);

                helper(people, res, seen);
                if(res.size()==people.length)
                    return;

                // System.out.println("rm  "+ i);

                seen[i]=false;
                res.remove(res.size()-1);
            }
        }


    }
}