// https://leetcode.com/problems/russian-doll-envelopes

class Solution {
    public int maxEnvelopes(int[][] env) {

        Arrays.sort(env, (a,b)->a[0]!=b[0]? a[0]-b[0]  : b[1]-a[1]);

        List<Integer> list = new ArrayList<>();
        int len = env.length;
        for(int i=0; i<len; i++){
            if(list.isEmpty() || env[i][1]>list.get(list.size()-1)){
                list.add(env[i][1]);
            }else{
                int idx = ceiling(list, env[i][1]);
                list.set(idx, env[i][1]);
            }
        }

        return list.size();

        
    }

    private int ceiling(List<Integer> list, int h){
        int st = 0, ed=list.size()-1;

        while(st<ed){ //0 ,1
            int mid = st+(ed-st)/2; // 0
            if(list.get(mid)>=h){
                ed = mid; // 0
            }else{
                st = mid+1; // 1
            }
        }

        return st;
    }
}